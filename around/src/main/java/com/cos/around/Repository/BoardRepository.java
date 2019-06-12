package com.cos.around.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.around.Model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
//	@Query(value="SELECT * FROM board where boardRegionNum = ?1  AND\n" + 
//			" userNum in(SELECT userNum from users where userAge between ?2 and ?3)", nativeQuery = true)
//		public Optional<List<Board>> findSearchBoard(int userSearchRegion, int userSearchMinAge, int userSearchMaxAge); 
	
	@Query(value="SELECT * FROM board where " + 
			" userNum in(SELECT userNum from users where userAge between ?1 and ?2 and boardActivate = 0)", nativeQuery = true)
		public List<Board> findSearchBoard(int userSearchMinAge, int userSearchMaxAge);
	public List<Board> findByBoardActivate(int activate);
	
	public Optional<Board> findByBoardNumAndBoardActivate(int num,int activate);
	
	
}
