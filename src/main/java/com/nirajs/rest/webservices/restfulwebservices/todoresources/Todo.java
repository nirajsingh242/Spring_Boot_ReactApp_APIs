package com.nirajs.rest.webservices.restfulwebservices.todoresources;

import java.util.Date;

import lombok.Data;

@Data
public class Todo {
	
	
	
	long id;
	String username;
	String description;
	Date targetDate;
	boolean completed;
	protected Todo()
	{
	}
	
	public Todo(long id, String username, String description, Date targetDate, boolean completed) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.completed = completed;
	}
	
	

}
