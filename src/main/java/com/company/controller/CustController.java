package com.company.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.company.constants.Roles;

import com.company.model.Accounts;
import com.company.model.Customer;
import com.company.repository.acctRepository;
import com.company.services.CustService;
import com.company.services.Notification;
import com.company.services.SecurityService;

@Controller
@SessionAttributes("userForm")
public class CustController {
  
	@Autowired
	private CustService custService;
	
	@Autowired
	private acctRepository repo;
	
	
	@Autowired
    private SecurityService securityService;
	
	
	
	
	@Autowired
	private Notification notify;
	
    @GetMapping("/create")
    public String registration(Model model) {
    	model.addAttribute("userForm", new Customer());
        return "create";
    }
    
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String registration(HttpServletRequest request,@ModelAttribute("userForm") Customer userForm, @RequestParam String username,@ModelAttribute("acct") Accounts acct,BindingResult bindingResult, Model model) {
       
    	
        if (bindingResult.hasErrors()) {
            return "create";
        }
//       model.addAttribute("username",userForm.getUsername());
        //model.addAttribute("acct",acct);
        
        //Customer cust = request.getSession().setAttribute("acct",acct);
        
        custService.save(userForm,Roles.ROLE_USER,acct);
        	//securityService.autoLogin(userForm.getUsername(), userForm.getPassword());
       // securityService.findAccountNum();
     
      
        
        return "login";
    }

    @GetMapping("/login")
	public String login(Model model, String error, String logout,ModelMap map, @ModelAttribute("acct") Accounts acct) {
		if (error != null)
			model.addAttribute("error", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		//Customer c = new Customer();
		
		//Customer user = (Customer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		  //String name = user.getUsername();
		 // model.addAttribute("username",c.getUsername());
		//model.addAttribute("acct",acct.getAccountnumber());
		return "login";
	}
    
//   @GetMapping("customerpreview")
//   public String customerpreview(Model model) {
//	   return "redirect:/login";
//   }
   
//    @PostMapping("/create/save")
//    public RedirectView saveUser(Customer cust,
//            @RequestParam("image") MultipartFile multipartFile) throws IOException {
//         
//        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        cust.setPhotos(fileName);
//         
//        Customer savedUser = custService.save(cust);
// 
//        String uploadDir = "user-photos/" + savedUser.getId();
// 
//        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//         
//        return new RedirectView("/create", true);
//    }

    
    @GetMapping("/customerdetails")
	public String customerdetails(Model model) {
		
    	
		return "customerdetails";
	}
    
    @GetMapping("/admin")
   	public String admin(Model model) {
       			return "admin";
   		
   	}
    
    
    @PostMapping("/admin")
   	public String admin(String username,String password) {
    		if(username.equals("Devanshi") && password.equals("devu123"))
    			return "display";
    		else
    			return "error";
   	}
    
    
    @GetMapping("/kycupload")
   	public String kycupload(Model model) {
    	
    	Customer cust = new Customer();
    	
    	try {
    		
    		notify.sendNotif(cust);
    	}
    	catch(MailException e) {
    		
    	}
   		return "kycupload";
   	}
    
    
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}