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

import com.cos.around.Model.Heart;
import com.cos.around.Repository.HeartRepository;

@RestController
@RequestMapping("/heart")
public class HeartController {

	@Autowired
	HeartRepository heartRepository;

	@PostMapping("/save")
	public Heart save(@RequestBody Heart heart) {

		return heartRepository.save(heart);
	}

	@GetMapping("/findall")
	public List<Heart> findAll() {

		return heartRepository.findAll();
	}

	@GetMapping("/findby/{num}")
	public Heart findByID(@PathVariable int num) {

		Optional<Heart> opR = heartRepository.findById(num);
		if (opR.isPresent()) {
			Heart heart = opR.get();
			return heart;
		}
		return null;

	}

	@PostMapping("/update")
	public Heart update(Heart heart) {
		System.out.println(heart.getHeartNum());

		return heartRepository.save(heart);
	}

	@PostMapping("/delete/{num}")
	public String delete(@PathVariable int num) {

		heartRepository.deleteById(num);

		return " \"delete\" : " + num;
	}
}
