package com.cos.crud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cos.crud.model.Board;
import com.cos.crud.service.BoardService;
import com.cos.crud.util.MyUtils;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	// http://localhost:8000/
	@GetMapping("/")
	public String home() {

		return "redirect:list";

	}

	@GetMapping("/list")
	public String findAll(Model model) {

		model.addAttribute("board", boardService.findAll());

		return "index";

	}

	// responseBody는 MessageConvertor(Jackson bind)를 실행시킨다
	// RequestBody는 MessageConvertor(Jackson bind)를 실행시킨다
	/*
	 * RequestBody가 없으면 x-www-form-urlencoded, text, multipart데이터(이미지, 영상)를 파싱 :
	 * form-data
	 */
	@PostMapping("/create")
	public String crete(Board board) {

		board.setUpdateDate(MyUtils.getCurrentTime());
		boardService.create(board);

		return "redirect:list";

	}

	@PostMapping("/update")
	public String update(Board board) {

		board.setUpdateDate(MyUtils.getCurrentTime());
		boardService.create(board);

		return "redirect:list";

	}

	@PostMapping("/delete/{num}")
	public String delete(@PathVariable int num) {

		int result = boardService.delete(num);
		if (result == 1) {
			return "redirect:list";
		} else {
			return "error";
		}

	}

	// http://localhost:8000/board/2
	@GetMapping("/{num}")
	public String view(@PathVariable int num, Model model) {

		Optional<Board> temp = boardService.detail(num);
		// 숙제 : null 처리하기(Optional)
		// Board board2 = boardService.getOne(1);
		
		if (temp.isPresent()) {
			Board board = temp.get();
			// Board board = temp.orElse(board2);
			model.addAttribute("board", board);
			return "detail";
		} else {
			return "error";
		}

	}

}
