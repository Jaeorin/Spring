package com.around.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.around.admin.model.Heart;

public interface HeartRepository extends JpaRepository<Heart, Integer>{

	@Query(value="select boardNum from heart group by boardNum  order by count(*) DESC Limit ?1", nativeQuery = true)
	public List<Integer> findCountPopularBoard(int limit);
	
	
}
