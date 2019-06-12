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

import com.cos.around.Model.Users;
import com.cos.around.Repository.UsersRepository;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UsersRepository userRepository;

	@PostMapping("/save")
	public Users save(@RequestBody Users user) {
		System.out.println(user);
		user.setUserActivate(1);
	
		return userRepository.save(user);
	}

	@GetMapping("/findall")
	public List<Users> findAll() {

		return userRepository.findAll();
	}

	@GetMapping("/findby/{num}")
	public Users findByID(@PathVariable int num) {

		Optional<Users> opR = userRepository.findById(num);
		if (opR.isPresent()) {
			Users user = opR.get();
			return user;
		}
		return null;

	}

	@PostMapping("/update")
	public Users update(Users user) {
		System.out.println(user.getUserNum());

		return userRepository.save(user);
	}

	@PostMapping("/delete/{num}")
	public String delete(@PathVariable int num) {

		userRepository.deleteById(num);

		return " \"delete\" : " + num;
	}
}
