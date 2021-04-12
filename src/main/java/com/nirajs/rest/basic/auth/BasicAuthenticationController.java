package com.nirajs.rest.basic.auth;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthenticationController {
	
	@GetMapping(value="/basicauth",produces = {"application/json"})
	public AuthenticationBean helloWorldBean()
	{
		System.out.print("Call acomplised");
		return new AuthenticationBean("Authentication Successfull");
		
	}
	

	
	
	
	
}
