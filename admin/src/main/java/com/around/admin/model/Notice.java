package com.around.admin.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Notice implements Comparable<Notice>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@CreationTimestamp
	private LocalDate createDate;
	@CreationTimestamp
	private LocalDate updateDate;
	
	private String title;
	
	private String content;

	@Override
	public int compareTo(Notice board) {
			long time1 = Integer.parseInt(this.createDate.toString().replaceAll("-", ""));
			long time2 = Integer.parseInt(board.getCreateDate().toString().replaceAll("-", ""));
			if(time1 < time2) {
				return -1;
			}else if(time1 > time2) {
				return 1;
			}
			return 0;
		}
}
