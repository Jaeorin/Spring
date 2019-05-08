package com.cos.crud.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
// lombok : getter, setter 자동생성
@Data
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;

	@Column(nullable = false, length = 100)
	private String title;
	@Column(nullable = false, length = 60000)
	@Lob
	private String content;
	private String userID;
	private Timestamp createDate;
	private Timestamp updateDate;

}
