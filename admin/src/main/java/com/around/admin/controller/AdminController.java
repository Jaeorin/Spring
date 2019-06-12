package com.around.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.around.admin.model.Board;
import com.around.admin.model.Notice;
import com.around.admin.model.PagingListDTO;
import com.around.admin.model.Question;
import com.around.admin.repository.BoardRepository;
import com.around.admin.repository.HeartRepository;
import com.around.admin.repository.NoticeRepository;
import com.around.admin.repository.QuestionRepository;
import com.around.admin.repository.ReportRepository;
import com.around.admin.service.BoardService;
import com.around.admin.util.MyUtils;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	BoardRepository boardRepository;

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	NoticeRepository noticeRepository;
	
	@Autowired
	ReportRepository reportRepository;
	@Autowired
	HeartRepository heartRepository;
	@Autowired
	BoardService boardService;
	
	@GetMapping("/")
	public String home(Model model) {
		
		PagingListDTO<Board> pageReports =new PagingListDTO<Board>();
		PagingListDTO<Question> pageQuestions =new PagingListDTO<Question>();
		PagingListDTO<Notice> pageNotices =new PagingListDTO<Notice>();
		
		
		
		List<Integer> reportList = reportRepository.findReportList();
		List<Board> boards = new ArrayList<Board>();
		for(int i: reportList) {
			
			Optional<Board> boardO = boardRepository.findById(i);
			Board board = new Board();
			if(boardO.isPresent()) {
				board = boardO.get();
				int reportCount= reportRepository.findReportCount(i);
				board.setReportCount(reportCount);
			}
			boards.add(board);
		}
		
		pageReports = MyUtils.paging(1, boards);
		
		
		
		List<Notice> notices = noticeRepository.findAll();
		pageNotices = MyUtils.paging(1, notices);
		
		List<Question> questions = questionRepository.findAll();
		pageQuestions = MyUtils.paging(1, questions);
		
		List<Board> webpageList =boardService.webPageList(1);
		
		model.addAttribute("noticelist", pageNotices);
		model.addAttribute("reportlist", pageReports);
		model.addAttribute("questionlist", pageQuestions);
		model.addAttribute("webpagelist", webpageList);
//		System.out.println("1:"+pageNotices.getMaxPage());
//		System.out.println("2:"+pageReports.getMaxPage());
//		System.out.println("3:"+pageQuestions.getMaxPage());
		
		return "admin";
	}
	

	@GetMapping("/report/findpage/{page}")
	public @ResponseBody PagingListDTO<Board> reportFind(@PathVariable int page) {
		PagingListDTO<Board> pageReports =new PagingListDTO<Board>();
		
		List<Integer> reportList = reportRepository.findReportList();
		List<Board> boards = new ArrayList<Board>();
		for(int i: reportList) {
			
			Optional<Board> boardO = boardRepository.findById(i);
			Board board = new Board();
			if(boardO.isPresent()) {
				board = boardO.get();
				int reportCount= reportRepository.findReportCount(i);
				board.setReportCount(reportCount);
			}
			boards.add(board);
		}
		pageReports = MyUtils.paging(page, boards);
		return pageReports;
	}

	@GetMapping("/question/findpage/{page}")
	public @ResponseBody PagingListDTO<Question> questionFind(@PathVariable int page) {

		PagingListDTO<Question> pageQuestions =new PagingListDTO<Question>();

		List<Question> questions = questionRepository.findAll();
		pageQuestions = MyUtils.paging(page, questions);
		return pageQuestions;
	}

	@PostMapping("/notice/save")
	public @ResponseBody Notice save(@RequestBody Notice notice) {
		Notice result = null;
		if(!(notice.getTitle() == "" || notice.getContent() == "")) {
		
		result = noticeRepository.save(notice);
		}
		return result; 
	}

	@GetMapping("/notice/findpage/{page}")
	public @ResponseBody PagingListDTO<Notice> findAll(@PathVariable int page) {
		
		List<Notice> notices = noticeRepository.findAll();
		PagingListDTO<Notice> pageNotices = MyUtils.paging(page, notices);
		System.out.println("notice");
		return pageNotices;
	}

	@GetMapping("/notice/findby/{num}")
	public Notice findByID(@PathVariable int num) {

		Optional<Notice> opR = noticeRepository.findById(num);
		if (opR.isPresent()) {
			Notice notice = opR.get();
			return notice;
		}
		return null;
	}

	@PostMapping("/notice/update")
	public Notice update(Notice notice) {
		return noticeRepository.save(notice);
	}

	@PostMapping("/notice/delete/{num}")
	public String delete(@PathVariable int num) {

		noticeRepository.deleteById(num);

		return " \"delete\" : " + num;
	}

}
