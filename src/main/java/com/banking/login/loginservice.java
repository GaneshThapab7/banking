package com.banking.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.banking.Configuration.CustomLoginSuccessHandler;
import com.banking.Model.Users;
import com.banking.Repository.UserRepository;

@Component
public class loginservice implements login{

	
	@Autowired
	private UserRepository userrepo;
	
	
	public CustomLoginSuccessHandler customLoginSuccessHandler=new CustomLoginSuccessHandler();
	
	public String loginin(logindto login) {
		
		Users user=new Users();
		user=userrepo.findbyusername(login.getUsername());
		if(user==null) {
			return "nouser";
		}
		else if(!login.getPassword().equals(user.getPassword())) {
			return "nopassword";
		}
		
		return customLoginSuccessHandler.determineTargetUrlbuuserrole(user.getRole());
	}

}
