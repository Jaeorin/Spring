package com.cos.around.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.around.Model.Board;
import com.cos.around.Model.Report;
import com.cos.around.Model.Users;

public interface ReportRepository extends JpaRepository<Report, Integer>{
	
	public Optional<Report> findByBoardAndUser (Board board, Users user);
}
