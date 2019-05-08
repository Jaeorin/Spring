package com.cos.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.crud.model.Board;

public interface BoardRepostory extends JpaRepository<Board, Integer> {

}
