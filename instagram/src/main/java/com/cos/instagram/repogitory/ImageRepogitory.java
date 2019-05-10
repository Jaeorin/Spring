package com.cos.instagram.repogitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.instagram.model.Images;

public interface ImageRepogitory extends JpaRepository<Images, Integer> {

}
