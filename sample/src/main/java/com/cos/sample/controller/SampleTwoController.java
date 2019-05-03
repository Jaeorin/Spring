package com.cos.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleTwoController {

	@GetMapping("/data")
	public String data() {
		return "hello everyone";
	}

}
