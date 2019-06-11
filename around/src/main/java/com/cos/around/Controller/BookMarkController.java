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

import com.cos.around.Model.BookMark;
import com.cos.around.Repository.BookMarkRepository;

@RestController
@RequestMapping("/bookmark")
public class BookMarkController {

	@Autowired
	BookMarkRepository bookMarkRepository;

	@PostMapping("/save")
	public BookMark save(@RequestBody BookMark bookMark) {

		return bookMarkRepository.save(bookMark);
	}

	@GetMapping("/findall")
	public List<BookMark> findAll() {

		return bookMarkRepository.findAll();
	}

	@GetMapping("/findby/{num}")
	public BookMark findByID(@PathVariable int num) {

		Optional<BookMark> opR = bookMarkRepository.findById(num);
		if (opR.isPresent()) {
			BookMark bookMark = opR.get();
			return bookMark;
		}
		return null;

	}

	@PostMapping("/update")
	public BookMark update(BookMark bookMark) {

		return bookMarkRepository.save(bookMark);
	}

	@PostMapping("/delete/{num}")
	public String delete(@PathVariable int num) {

		bookMarkRepository.deleteById(num);

		return " \"delete\" : " + num;
	}
}
