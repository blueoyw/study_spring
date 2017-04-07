package com.board.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//GET Method만 mapping
	@GetMapping("/add")	
	public String addNewUser( @RequestParam String name, @RequestParam String email ) {
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}
	
	@GetMapping("/all")
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
}
