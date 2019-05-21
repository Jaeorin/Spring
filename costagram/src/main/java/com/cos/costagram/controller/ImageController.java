package com.cos.costagram.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.cos.costagram.service.CustomUserDetails;

@Controller
public class ImageController {
	
	@GetMapping("/images")
	public String image(@AuthenticationPrincipal CustomUserDetails userDetail) {
		System.out.println(userDetail.getUsername());
		return "/images/image";
	}
}
