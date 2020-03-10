package com.banking.login;


import com.banking.Model.users;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/login")
public class LoginController {
   
	
	
	@Autowired
	private login logininterface;

    @GetMapping
    private String getLoginPage(Model model) {
        return "login";
   }

//    @PostMapping(value = "/loginConfirm")
//    private String loginCheck(Model model, User){
//
//    }

    @PostMapping
    public String login(@ModelAttribute("logindto") logindto logindto,ModelMap mod) {

       /* Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            System.out.println(auth.getDetails());
            System.out.printf("123");
            System.out.println(auth.getAuthorities());
            return "redirect:/admin/dashboard";
        }*/

    String loginreport=	logininterface.loginin(logindto);
    System.out.println(loginreport);
    	if(loginreport.equals("nouser")) {
    		mod.addAttribute("message", "User Dosent Exist!!!");
    		return "redirect:/login";
    	}else if(loginreport.equals("nopassword")) {
    		mod.addAttribute("message", "Password Dosent Match!!!");
    		return "redirect:/login";
    	}else if(loginreport.equals("/login?error=true")) {
    		mod.addAttribute("message", "Role For This User Is Not Defined!!!");
    		return "redirect:/login";
    		
    	}
    	
    	return "redirect:"+loginreport;
    }

}
