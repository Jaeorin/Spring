package com.cos.around.DTO;

import java.util.List;

import com.cos.around.Model.Board;
import com.cos.around.Model.Tags;

import lombok.Data;

@Data
public class DetailDTO {
	
	private Board board; //게시판
	
	private List<Board> popBoards; //우측 인기 게시판
	
	private List<Tags> poptags; //우측 인기 태그 끝
	
	private Board prevBoard; //이전글
	
	private Board nextBoard; //이후글
	
	private List<Board> adminBoards; //관리자 추천글
	
	private List<Board> randomBoards; //하단 랜덤글
}
