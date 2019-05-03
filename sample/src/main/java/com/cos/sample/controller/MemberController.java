package com.cos.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.sample.model.Member;
import com.cos.sample.repository.MemberRepository;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberRepository repository;
	
	@GetMapping("/list")
	public List<Member> findAll() {
		
		List<Member> list = repository.findAll();
		
		return list;
		
	}
	
	@PostMapping("/create")
	public String save(@RequestBody Member member) {
		
		repository.save(member);
		
		return "OK";
		
	}

}
