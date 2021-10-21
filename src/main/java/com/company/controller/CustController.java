package com.company.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.constants.Roles;
import com.company.model.Accounts;
import com.company.model.Customer;
import com.company.repository.CustRepository;
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
    private SecurityService securityService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
		
	
	@Autowired
	private Notification_cust notify_cust;
	
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
        
        System.out.println(userForm.getName());
//        model.addAttribute("username",userForm.getUsername());
//        model.addAttribute("acct",acct.getAccountnumber());
        
        
        custService.save(userForm,Roles.ROLE_USER,acct);
        	//securityService.autoLogin(userForm.getUsername(), userForm.getPassword());
       
        //sending notification
        
        try {
        	
        	notify_reg.sendNotif(userForm);
        	
        }
        catch(MailException e) {
        	
        }
        if(userForm!=null) {
        	model.addAttribute("message", "Account is created successfully");
        }
        
        else {
        	model.addAttribute("message", "Login here");
        }
        
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
   	public String admin(String username,String password,HttpServletRequest request,@ModelAttribute("cust") Customer cust) {
    		if(username.equals("Devanshi") && password.equals("devu123")) {
    			request.setAttribute("users",custService.getCust());
    		
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
	public String sendmail(@RequestParam(required=false,name="email") String email, ModelMap model,Customer cust) {
    	Customer user = custRepository.findByEmail(cust.getEmail());
    	
    	  
		try {
			notifi.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		
		return "success";
	}

    
//    @PostMapping("/accept")
//   	public String updatemail(@RequestParam(required=false,name="email") String email, ModelMap model,Customer cust) {
//    	 
//    	Customer user = custRepository.findByEmail(getUserEmail(model));
//    	
//  
//		try {
//			notifi.sendEmail(user);
//		} catch (MailException mailException) {
//			System.out.println(mailException);
//		}
//		return "Mail sent successfully";
//    }

    
    @GetMapping("/confirm")
   	public String confirm(@RequestParam(required=false,name="email") String email, ModelMap model,Customer cust) {
       	Customer user = custRepository.findByEmail(cust.getEmail());
       	
       	  
   		try {
   			notify_cust.sendEmail(user);
   		} catch (MailException mailException) {
   			System.out.println(mailException);
   		}
   		
   		return "success";
   	}
    
    private String getUserEmail(ModelMap model) {
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