package com.cos.around.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.around.Model.Board;
import com.cos.around.Model.Region;
import com.cos.around.Model.Users;
import com.cos.around.Repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	public Board create(Optional<Board> optionalBoard) {
		if (optionalBoard.isPresent()) {
			Board board = optionalBoard.get();

			Board result = boardRepository.save(board);

			return result;
		} else {
			return null;
		}
	}

	public List<Board> findSearchBoard(Users user) {
		List<Board> boards = new ArrayList<Board>();
		int userSearchMinAge = user.getUserSearchMinAge();
		int userSearchMaxAge = user.getUserSearchMaxAge();
		Region userSearchRegion = user.getUserSearchRegion();

		List<Board> bs = boardRepository.findSearchBoard(userSearchMinAge, userSearchMaxAge);
		if (!user.getUserSearchRegion().toString().equals("전국")) {
			
			for (Board b : bs) {
				if (b.getBoardRegion().equals(userSearchRegion)) {
					boards.add(b);
				}
			}
		}

		return boards;
	}

}
