package com.around.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.around.admin.model.AttachFile;

public interface AttachFileRepository extends JpaRepository<AttachFile, Integer>{
	public List<AttachFile> findByBoardBoardNum(int boardNum);
}
