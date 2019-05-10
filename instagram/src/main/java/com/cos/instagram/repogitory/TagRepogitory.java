package com.cos.instagram.repogitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.instagram.model.Tags;

public interface TagRepogitory extends JpaRepository<Tags, Integer> {

}
