package com.cos.around.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.around.Model.AttachFile;

public interface AttachFileRepository extends JpaRepository<AttachFile, Integer>{
	public List<AttachFile> findByBoardBoardNum(int boardNum);
}
