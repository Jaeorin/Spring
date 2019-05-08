package com.cos.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.crud.model.Board;
import com.cos.crud.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	// http://localhost:8000/
	@GetMapping("/")
	public String home() {

		return "redirect:/board/list";

	}

	@GetMapping("/list")
	public String findAll(Model model) {

		model.addAttribute("boards", boardService.findAll());

		return "index";

	}

	// responseBody는 MessageConvertor(Jackson bind)를 실행시킨다
	// RequestBody는 MessageConvertor(Jackson bind)를 실행시킨다
	/*
	 * RequestBody가 없으면 x-www-form-urlencoded, text, multipart데이터(이미지, 영상)를 파싱 :
	 * form-data
	 */
	@PostMapping("/create")
	public @ResponseBody Board create(@RequestBody Board board) {

		return boardService.create(board);

	}

	@PostMapping("/delete")
	public @ResponseBody String delete(int num) {

		int result = boardService.delete(num);
		if (result == 1) {
			return "delete success";
		} else {
			return "delete fail";
		}

	}

}
