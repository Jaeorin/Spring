package com.cos.around.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.around.Model.InsertTag;
import com.cos.around.Repository.InsertTagRepository;

@RestController
@RequestMapping("/inserttag")
public class InsertTagController {

	@Autowired
	InsertTagRepository insertTagRepository;

	@PostMapping("/save")
	public InsertTag save(@RequestBody InsertTag insertTag) {
		
	
		return insertTagRepository.save(insertTag);
	}

	
	@GetMapping("/findall")
	public List<InsertTag> findAll() {

		return insertTagRepository.findAll();
	}

	@GetMapping("/findby/{num}")
	public InsertTag findByID(@PathVariable int num) {

		Optional<InsertTag> opR = insertTagRepository.findById(num);
		if (opR.isPresent()) {
			InsertTag insertTag = opR.get();
			
			return insertTag;
		}
			return null;

	}

	@PostMapping("/update")
	public InsertTag update(InsertTag insertTag) {

		return insertTagRepository.save(insertTag);
	}

	@PostMapping("/delete/{num}")
	public String delete(@PathVariable int num) {

		insertTagRepository.deleteById(num);

		return " \"delete\" : " + num;
	}
}
