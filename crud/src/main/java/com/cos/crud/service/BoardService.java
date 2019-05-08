package com.cos.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.crud.model.Board;
import com.cos.crud.repository.BoardRepostory;

// Controller, Service, RestContriller, Component, Repository
@Service
public class BoardService {
	
	@Autowired
	private BoardRepostory boardRepostory;
	
	public Board create(Board board) {
		
		// findAll(), findByID(), save(), delete()
		return boardRepostory.save(board);
		
	}
	
	public List<Board> findAll() {
		
		return boardRepostory.findAll();
		
	}
	
	// jsp삭제 -> primary key
	// spring -> entity -> board
	// spring -> id
	public int delete(int num) {
		
		try {
			boardRepostory.deleteById(num);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}

}
