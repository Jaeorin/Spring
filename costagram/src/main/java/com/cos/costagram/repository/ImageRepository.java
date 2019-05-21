package com.cos.costagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.costagram.model.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

}
