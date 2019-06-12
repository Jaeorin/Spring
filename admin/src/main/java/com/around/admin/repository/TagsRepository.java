package com.around.admin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.around.admin.model.Tags;

public interface TagsRepository extends JpaRepository<Tags, Integer>{
	public Optional<Tags> findByTagName(String tagName);
}
