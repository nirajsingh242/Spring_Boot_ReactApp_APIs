package com.nirajs.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {
	
	//@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	@GetMapping(path="/hello-world")
	public String helloWorld()
	{
		return "Hello World";
		
	}
	
	@GetMapping(value="/hello-world-bean",produces = {"application/json"})
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello World Bean");
		
	}
	
	//one path variable
	@GetMapping(value="/hello-world/path-variable/{name}",produces = {"application/json"})
	public HelloWorldBean helloWorldBean(@PathVariable String name)
	{
		//throw new RuntimeException( "Something Went Wrogn");
		System.out.print("Call acomplised hello world");
		return new HelloWorldBean(String.format("Hello World %s" , name));
		
	}
	//more than 1 path variable
	@GetMapping(value="/hello-world/path-variable/{name}/{id}",produces = {"application/json"})
	public HelloWorldBean helloWorldBean(@PathVariable("name") String name,@PathVariable("id") String id)
	{
		String nameid=String.format("Hello World %s" , name)+" "+String.format("Id is %s" , id);
		return new HelloWorldBean(nameid);
		
	}

	
	
	
	
}
