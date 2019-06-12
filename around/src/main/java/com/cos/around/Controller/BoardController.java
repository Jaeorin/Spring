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
import org.springframework.web.bind.annotation.RestController;

import com.cos.around.Model.Board;
import com.cos.around.Model.InsertTag;
import com.cos.around.Model.Report;
import com.cos.around.Model.Tags;
import com.cos.around.Model.Users;
import com.cos.around.Repository.AttachFileRepository;
import com.cos.around.Repository.BoardRepository;
import com.cos.around.Repository.InsertTagRepository;
import com.cos.around.Repository.ReportRepository;
import com.cos.around.Repository.TagsRepository;
import com.cos.around.Service.BoardService;
import com.cos.around.Utils.MyUtils;

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
	
	@Autowired
	ReportRepository reportRepository;
	

	@PostMapping("/report")
	public String report(@RequestBody Report report) {
		Optional<Report> reportO = reportRepository.findByBoardAndUser(report.getBoard(), report.getUser());
		if(!reportO.isPresent()) {
			
		reportRepository.save(report);
		}
		
		return "OK";
	}
	
	@PostMapping("/save")
	public Board save(@RequestBody Board board) {
		
		List<InsertTag> insTags = new ArrayList<InsertTag>();
		List<String> tagList = MyUtils.extractHashTag(board.getBoardContent());
		
		if (tagList != null) {

			for (String s : tagList) {
				Tags tag = new Tags();
					tag.setTagName(s);
				Optional<Tags> opTag = tagsRepository.findByTagName(s);
				if (opTag.isPresent()) {
					tag.setTagNum(opTag.get().getTagNum());
				} else {
					tag = tagsRepository.save(tag);
				}
				InsertTag insTag = new InsertTag();
				insTag.setTag(tag);
				insTags.add(insTag);
			}
		}
		Optional<Board> optionalBoard = Optional.ofNullable(board);
		Board result = boardService.create(optionalBoard);

		if (insTags != null) {
			for (InsertTag t : insTags) {
				t.setBoard(new Board());
				t.getBoard().setBoardNum(result.getBoardNum());
				insertTagRepository.save(t);

			}
		}
		return result;
	}

	@GetMapping("/findall")
	public List<Board> findAll() {

		return boardRepository.findByBoardActivate(0);

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

		Optional<Board> opR = boardRepository.findByBoardNumAndBoardActivate(num, 0);
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
