package com.cos.instagram.repogitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.instagram.model.Tags;

public interface TagRepogitory extends JpaRepository<Tags, Integer> {
	
	public List<Tags> findByNameContaining(String name);
	
//	@Query()
//	public List<Tags> findByNameAndId(String name, int id);

}
