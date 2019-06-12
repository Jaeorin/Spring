package com.around.admin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.around.admin.model.Board;
import com.around.admin.model.Report;
import com.around.admin.model.Users;

public interface ReportRepository extends JpaRepository<Report, Integer>{
	
	public Optional<Report> findByBoardAndUser (Board board, Users user);
	
	@Query(value = "SELECT boardNum FROM report group by boardNum ORDER BY reportNum DESC" , nativeQuery = true)
	public List<Integer> findReportList();
	
	@Query(value = "SELECT COUNT(*) FROM report WHERE boardNum= ?1", nativeQuery = true)
	public int findReportCount(int boardNum);
}
