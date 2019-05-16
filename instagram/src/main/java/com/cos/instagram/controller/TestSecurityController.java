package com.cos.instagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// View Resolver가 관여
@Controller
public class TestSecurityController {

	@GetMapping("/")
	public String home() {
		
		return "index";
		
	}
	
	@GetMapping("/user/login")
	public String userLogin(HttpSession session, HttpServletRequest request) {
		
		return "user/login";
		
	}
	
	@GetMapping("/image/explore")
	public String userExplore() {
		
		return "user/explore";
		
	}
	
}
