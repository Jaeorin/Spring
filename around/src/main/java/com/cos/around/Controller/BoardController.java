package com.cos.around.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.around.Model.AttachFile;
import com.cos.around.Model.Board;
import com.cos.around.Model.InsertTag;
import com.cos.around.Model.Tags;
import com.cos.around.Model.Users;
import com.cos.around.Repository.AttachFileRepository;
import com.cos.around.Repository.BoardRepository;
import com.cos.around.Repository.InsertTagRepository;
import com.cos.around.Repository.TagsRepository;
import com.cos.around.Service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardRepository boardRepository;

	@Autowired
	BoardService boardService;

	@Autowired
	TagsRepository tagsRepository;

	@Autowired
	InsertTagRepository insertTagRepository;

	@Autowired
	AttachFileRepository attachFileRepository;

	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "test";
	}

	@PostMapping("/save")
	public Board save(@RequestBody Board board) {
		System.out.println(board);
		List<InsertTag> insTags = board.getInsertTag();

		if (insTags != null) {
			int len = insTags.size();

			for (int i = 0; i < len; i++) {
				Tags tag = insTags.get(i).getTag();
				Optional<Tags> opTag = tagsRepository.findByTagName(tag.getTagName());
				if (opTag.isPresent()) {
					tag.setTagNum(opTag.get().getTagNum());
				} else {
					tagsRepository.save(tag);
				}
			}
		}
		Optional<Board> optionalBoard = Optional.ofNullable(board);
		Board result = boardService.create(optionalBoard);

		if (insTags != null) {
			for (InsertTag insTag : insTags) {

				insTag.getBoard().setBoardNum(result.getBoardNum());
				insertTagRepository.save(insTag);

			}
		}
		return result;
	}

	@GetMapping("/findall")
	public List<Board> findAll() {

		return boardRepository.findAll();

	}

	@PostMapping("/main")
	public List<Board> main(@RequestBody Users user) {
		System.out.println(user);

		List<Board> boards = boardService.findSearchBoard(user);

		if (boards.size() != 0) {

			return boards;
		} else {
			return null;
		}
	}

	@GetMapping("/findby/{num}")
	public Board findByID(@PathVariable int num) {

		Optional<Board> opR = boardRepository.findById(num);
		if (opR.isPresent()) {
			Board board = opR.get();

			return board;

		}
		return null;

	}

	@PostMapping("/update")
	public Board update(Board board) {

		return boardRepository.save(board);
	}

	@PostMapping("/delete/{num}")
	public String delete(@PathVariable int num) {

		boardRepository.deleteById(num);

		return " \"delete\" : " + num;
	}

}
