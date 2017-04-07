package com.board.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.board.entity.User;
import com.board.entity.UserRepository;
import com.board.json.Greeting;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private UserRepository userRepository;
		
	@RequestMapping("/greeting")
	public Greeting greeting( @RequestParam(value="name", defaultValue="world") String name ) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	//json으로 받을 수 있도록 변경.
	//GET Method만 mapping
	//@GetMapping("/add")
	@PostMapping("/users")	
	public String addNewUser( @RequestParam String name, @RequestParam String email ) {
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}
	
	@GetMapping("/users")
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable("id") long id ) {		
		return userRepository.findOne(id);
	}
	
	//json으로 받을 수 있도록 변경.	
	@PutMapping("/users/{id}")
	public User updateUser( @PathVariable("id") long id, @RequestBody User user ) {		
		userRepository.save(user);
		return userRepository.findOne(id);		
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUser( @PathVariable("id") long id ) {
		userRepository.delete(id);
		return "Deleted";
	}
}
