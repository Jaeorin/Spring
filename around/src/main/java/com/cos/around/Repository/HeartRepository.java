package com.cos.around.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.around.Model.Heart;

public interface HeartRepository extends JpaRepository<Heart, Integer>{

	@Query(value="select boardNum from heart group by boardNum  order by count(*) DESC Limit 2", nativeQuery = true)
	public List<Integer> findCountPopularBoard();
	
	
}
