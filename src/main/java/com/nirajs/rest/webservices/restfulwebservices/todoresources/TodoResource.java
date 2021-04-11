package com.nirajs.rest.webservices.restfulwebservices.todoresources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {
	@Autowired
	TodoHardCodedService todoHardCodedService; 
	
	@GetMapping(value="/users/{username}/todos",produces = {"application/json"})
	public List<Todo> getAllTodo(@PathVariable("username") String  username)
	{
		return  todoHardCodedService.findAll();
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable("username") String  username,@PathVariable("id") long id)
	{
		Todo todo =todoHardCodedService.deleteById(id);
		
		if(todo!=null)
		{
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
		
	}
	
	
	//gettign todo as per todo id
	@GetMapping(value="/users/{username}/todos/{id}",produces = {"application/json"})
	public Todo getTodoById(@PathVariable("username") String  username,@PathVariable("id") long  id)
	{
		return  todoHardCodedService.findById(id);
	}
	
	//preparing put method for updating todo
	
	//edit/update a todo
	//PUT /users/{username}/todos/{id}
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable("username") String  username,@PathVariable("id") long id,@RequestBody Todo todo)
	{
		Todo updatedTodo=todoHardCodedService.save(todo);
		
		return new ResponseEntity<Todo>(todo,HttpStatus.OK);
		
	}

	
	//Creating a New Todo.
	//POST /users/{username}/todos/
	
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Void> creatTodo(@PathVariable("username") String  username,@RequestBody Todo todo)
	{
		Todo createdTodo=todoHardCodedService.save(todo);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return  ResponseEntity.created(uri).build();
		
	}


}
