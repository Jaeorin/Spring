package com.cos.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SampleController {

	@GetMapping("/home")
	public String home() {
		
		System.out.println("home");
		
		return "index.html";
		
	}
	
	@PostMapping("/room")
	public String homeRoom() {
		
		System.out.println("z");

		return "room.html";
		
	}
	
	
	
}
