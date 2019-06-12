package com.around.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.around.admin.model.Board;
import com.around.admin.repository.BoardRepository;
import com.around.admin.repository.HeartRepository;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;

	@Autowired
	HeartRepository heartRepository;
	
	public List<Board> webPageList(int num){
		List<Integer> popList = heartRepository.findCountPopularBoard(27);
		System.out.println("poplist"+popList);
		//List<Board> boards = boardRepository.findAllById(popList);
		List<Board> boards = new ArrayList<>();
		for(int i : popList) {
		Optional<Board> boardO = boardRepository.findById(i);
			if(boardO.isPresent()) {
				Board board = boardO.get();
				boards.add(board);
			}
		}
		
		return boards;
	}

}
