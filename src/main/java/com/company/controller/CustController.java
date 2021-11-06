package com.company.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.constants.Roles;
import com.company.model.Accounts;
import com.company.model.Customer;
import com.company.model.Kyc;
import com.company.repository.CustRepository;
import com.company.repository.acctRepository;
import com.company.services.CustService;
import com.company.services.MailService;
import com.company.services.Notification_cust;
import com.company.services.Notification_reg;
import com.company.services.SecurityService;
import com.company.services.UpdateNotification;

@Controller

public class CustController {
  
	@Autowired
	private CustService custService;
		
	
	
	@Autowired
	private CustRepository custRepository;
	
	@Autowired
	private MailService notifi;
	
	
	@Autowired
	acctRepository acctRepo;
	
	@Autowired
    private SecurityService securityService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private JavaMailSender jms;
	

	
	@Autowired
	private Notification_reg notify_reg;
	
	@Autowired
	private UpdateNotification update;
	
    @GetMapping("/create")
    public String registration(Model model) {
        model.addAttribute("userForm", new Customer());

        return "create";
    }
   
    @PostMapping("/create")
    public String registration(@ModelAttribute("userForm") Customer userForm, @ModelAttribute("acct") Accounts acct,BindingResult bindingResult, Model model,RedirectAttributes redirectAtt) {
       

    	//ModelAndView mv = new ModelAndView("customerdetails.jsp");
    	 
    
    	
    	
        if (bindingResult.hasErrors()) {
        	
        	
            return "create";
        }
        
       
        model.addAttribute("message", "Please Confirm and proceed to Login!!!");
        
        
        
        return "confirmation";
    }
    
    @PostMapping("/confirmation")
    public String confirm(@ModelAttribute("userForm") Customer userForm, BindingResult bindingResult, Model model, Accounts acct,ModelMap map,Kyc k) {
       

    	//ModelAndView mv = new ModelAndView("customerdetails.jsp");
    	 
    
    	
    
        if (bindingResult.hasErrors()) {
        	
        	
            return "confirmation";
        }
         
        System.out.println(userForm.getName());
       // model.addAttribute("userForm", "");
        
        System.out.println("confirm "+userForm.getName());
        System.out.println("confirm "+userForm.getPassword());

        
       custService.save(userForm,Roles.ROLE_USER,acct,k);
        	
       
        //sending notification
        
        try {
        	
        	notify_reg.sendNotif(userForm);
        	
        }
        catch(MailException e) {
        	
        }
        
      
       
        
        model.addAttribute("message", "Your account has been created successfully");
        
        model.addAttribute("userForm", new Customer());
        
        return "login";
    }
    
    @GetMapping("/login")
	public String login(Model model, String error, String logout,ModelMap map,Customer cust) {
		if (error != null)
			model.addAttribute("error", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		//Customer c = new Customer();
		
		//Customer user = (Customer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		  //String name = user.getUsername();
		 // model.addAttribute("username",c.getUsername());
		return "login";
	}
   
    
    @GetMapping("/forgot")
    public String forgotPassword(Model model) {
        model.addAttribute("userForm", new Customer());

        return "forgot";
    }
    
    @PostMapping("/forgot")
    public String forgotPassword(@ModelAttribute("userForm") Customer userForm,BindingResult bindingResult, Model model, Accounts acct,ModelMap map) {
       

    	//ModelAndView mv = new ModelAndView("customerdetails.jsp");
    	
    	
    	 
    	String mail = custRepository.findByEmailAddress(userForm.getEmail());
    	
       if (bindingResult.hasErrors()) {
        	
        	
            return "forgot";
        }
       
       if(mail == null)
       {
    	   model.addAttribute("mail", "* The given email does not exist *");
    	   return "forgot";
    	  
       }
       
     
//        
//       
      
       
       System.out.println(userForm.getPassword());
        

       userForm.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
       System.out.println(userForm.getPassword());
       
       custRepository.updatePassword(userForm.getEmail(), userForm.getPassword());
       
       
       update.updateNotif(userForm.getEmail());
      
       
       
        if(userForm!=null) {
        	
        	map.addAttribute("message", "Password Reseted Successfully");
        }
        
        else {
        	model.addAttribute("message", "Login here");
        }
//        
//        
//        
               return "login";
  }
    
    
    @GetMapping("/customerdetails")
	public String customerdetails(Model model, HttpServletRequest req ) {
		
    	req.getSession().setAttribute("acctNum", "CITY202123456");
    	
		return "customerdetails";
	}
   
    
    @GetMapping("/admin")
   	public String admin(Model model) {
       			return "admin";
   		
   	}
    
    
    @PostMapping("/admin")
   	public String admin(String username,String password,HttpServletRequest request) {
    		if(username.equals("Devanshi") && password.equals("devu123")) {
    			
    			request.setAttribute("ks",custService.getKyc());
    		
//    			Customer user = custRepository.findByEmail(cust.getEmail());
//    	    	System.out.println(user);
//    	  
//    			try {
//    				notifi.sendEmail(cust);
//    			} catch (MailException mailException) {
//    				System.out.println(mailException);
//    			}
    			return "display";
    		
    		}
    		
    		else
    		return "admin";
   	}
    
    @GetMapping("/accept")
	public String sendmail(@RequestParam Long id,@RequestParam String accnum,HttpServletRequest request,
			 ModelMap model) {
		String mail = getUserEmail();
		Kyc k = new Kyc();
		//Customer user1 = new Customer();
		//Customer user = custRepository.findByUsername(userForm.getUsername());
		System.out.println(mail);

		try {
			
			SimpleMailMessage email1 = new SimpleMailMessage();
			
			email1.setFrom("dev26134@gmail.com");
			email1.setTo(mail);

			email1.setSubject("Kyc done");
			email1.setText("thanks for cooperating");
			jms.send(email1);

		} catch (MailException mailException) {
			System.out.println(mailException);
		}

		// custService.deleterec(id); 
		
		custService.deleterec(id);
		System.out.println(accnum);
		acctRepo.updFlag(accnum);
	
		request.setAttribute("ks", custService.getKyc());
		model.addAttribute("message", id + " is succesfully verified");

		return "display";
	}

    
    @GetMapping("/reject")
	public String sendrejmail(@RequestParam(required=false,name="email") String email,final RedirectAttributes rA, @ModelAttribute("userForm") Customer userForm,ModelMap model,Customer cust) {
    	String mail = getUserEmail();
    	
    	rA.addFlashAttribute("css", "Success");
        rA.addFlashAttribute("msg", "The mail is sent");
    	
        System.out.println(mail);
        	  
    		try {
    			Customer user = new Customer();
    			SimpleMailMessage email1 = new SimpleMailMessage();
    			System.out.println(user.getEmail());
    			email1.setFrom("dev26134@gmail.com");
    			email1.setTo(mail);
    			
    			email1.setSubject("Kyc rejected");
    			email1.setText("thanks for cooperating");
    			jms.send(email1);
    			
    		} catch (MailException mailException) {
    			System.out.println(mailException);
    		}
    		
    		
    		
    		return "redirect:/admin";
	}

    
//    @GetMapping("/deleterec")
//   	public String deleterec(@RequestParam Long id,HttpServletRequest request) {
//    	
//    	custService.deleterec(id);
//    	return "redirect:/admin";
//    }

    
    @GetMapping("/confirm")
   	public String confirm(@RequestParam(required=false,name="email") String email, ModelMap model,Customer cust) {
       	String mail = getUserEmail();
       System.out.println(mail);
       	  
   		try {
   			Customer user = new Customer();
   			SimpleMailMessage email1 = new SimpleMailMessage();
   			System.out.println(user.getEmail());
   			email1.setFrom("dev26134@gmail.com");
   			email1.setTo(mail);
   			
   			email1.setSubject("Kyc request initiated");
   			email1.setText("thanks for cooperating");
   			jms.send(email1);

   		} catch (MailException mailException) {
   			System.out.println(mailException);
   		}
   		
   		return "success";
   	}
    
    private String getUserEmail() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	
//    @GetMapping("/display")
//    public String display(Model model,HttpServletRequest request ) {
//    	
//    
//    	//request.setAttribute("users",custService.findeKyc());
//    	
//    	
//		return "display";
//    	
//    }
//    
    
    @GetMapping("/kycupload")
   	public String kycupload(Model model) {
   		Customer cust = new Customer();
//    	try {
//    		
//    		notify.sendNotif(cust.getEmail());
//    	}
//    	catch(MailException e) {
//    		
//    	}
   		return "kycupload";
   	}
    
    
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}