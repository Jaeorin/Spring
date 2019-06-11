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

import com.cos.around.Model.Feeling;
import com.cos.around.Repository.FeelingRepository;

@RestController
@RequestMapping("/feeling")
public class FeelingController {

	@Autowired
	FeelingRepository feelingRepository;

	@PostMapping("/save")
	public Feeling save(@RequestBody Feeling feeling) {

		return feelingRepository.save(feeling);
	}

	@GetMapping("/findall")
	public List<Feeling> findAll() {

		return feelingRepository.findAll();
	}

	@GetMapping("/findby/{num}")
	public Feeling findByID(@PathVariable int num) {

		Optional<Feeling> opR = feelingRepository.findById(num);
		if (opR.isPresent()) {
			Feeling feeling = opR.get();
			return feeling;
		}
		return null;

	}

	@PostMapping("/update")
	public Feeling update(Feeling feeling) {

		return feelingRepository.save(feeling);
	}

	@PostMapping("/delete/{num}")
	public String delete(@PathVariable int num) {

		feelingRepository.deleteById(num);

		return " \"delete\" : " + num;
	}
}
