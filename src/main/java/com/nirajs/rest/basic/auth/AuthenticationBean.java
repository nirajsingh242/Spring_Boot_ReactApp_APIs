package com.nirajs.rest.basic.auth;

import lombok.Data;


@Data
public class AuthenticationBean  {
	
	public AuthenticationBean(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}

	public String message;

}
