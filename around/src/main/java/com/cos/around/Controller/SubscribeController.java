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

import com.cos.around.Model.Subscribe;
import com.cos.around.Repository.SubscribeRespository;

@RestController
@RequestMapping("/subscribe")
public class SubscribeController {

	@Autowired
	SubscribeRespository subscribeRepository;

	@PostMapping("/save")
	public Subscribe save(@RequestBody Subscribe subscribe) {

		return subscribeRepository.save(subscribe);
	}

	@GetMapping("/findall")
	public List<Subscribe> findAll() {

		return subscribeRepository.findAll();
	}

	@GetMapping("/findby/{num}")
	public Subscribe findByID(@PathVariable int num) {

		Optional<Subscribe> opR = subscribeRepository.findById(num);
		if (opR.isPresent()) {
			Subscribe subscribe = opR.get();
			return subscribe;
		}
		return null;

	}

	@PostMapping("/update")
	public Subscribe update(Subscribe subscribe) {

		return subscribeRepository.save(subscribe);
	}

	@PostMapping("/delete/{num}")
	public String delete(@PathVariable int num) {

		subscribeRepository.deleteById(num);

		return " \"delete\" : " + num;
	}
}
