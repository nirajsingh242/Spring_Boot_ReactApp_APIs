package com.nirajs.rest.webservices.restfulwebservices.helloworld;

import lombok.Data;


@Data
public class HelloWorldBean  {
	
	public HelloWorldBean(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}

	public String message;

}
