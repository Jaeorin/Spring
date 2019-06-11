package com.cos.around.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.around.Model.Tags;

public interface TagsRepository extends JpaRepository<Tags, Integer>{
	public Optional<Tags> findByTagName(String tagName);
}
