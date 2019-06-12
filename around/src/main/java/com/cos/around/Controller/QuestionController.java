package com.cos.around.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.around.Model.Question;
import com.cos.around.Repository.QuestionRepository;
 

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionRepository questionRepository;
	
	@PostMapping("/save")
	public String question(@RequestBody Question question) {
			
		questionRepository.save(question);
		
		
		return "OK";
	}

}
