package com.nirajs.rest.webservices.restfulwebservices.todoresources;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoHardCodedService {
	
	private static List<Todo> todos=new ArrayList(); 
	private static int count=0;
	static{
		
		todos.add(new Todo(++count," Satvik Singh","learning React by Saatvik Sir",new Date(),false));
		todos.add(new Todo(++count," Rahul Singh","learning React by Lester Sir",new Date(),true));
		todos.add(new Todo(++count," Sanket Saini","learning React by Lester Sir",new Date(),false));
		todos.add(new Todo(++count," Ashish more","learning React by Lester Sir",new Date(),true));
		
	}
	
	public List<Todo> findAll()
	{
		return todos;
	}
	
	public Todo deleteById(long id)
	{
		Todo todo=findById(id);
		
		if(todo==null)
		{
			return null;
		}
		if(todos.remove(todo))
			return todo;
		
		return null;
		
		
	}
	
	public Todo findById(long id)
	{
		for(Todo todo:todos)
		{
			if(todo.getId()==id)
				return todo;
		}
		
		return null;
	}
	
	
	//for saving and updating todo
	public Todo save(Todo todo)
	{
		if(todo.getId()==-1 || todo.getId()==0)
		{
			todo.setId(++count);
			todos.add(todo);
		}
		else
		{
			deleteById(todo.getId());//this method deletes pased id todo and returns deleted todo
			todos.add(todo);
		}
		return todo;
	}

}
