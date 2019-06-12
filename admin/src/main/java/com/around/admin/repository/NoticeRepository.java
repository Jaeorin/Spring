package com.around.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.around.admin.model.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer>{
	
}
