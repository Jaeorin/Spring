package com.cos.eround.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class Eround {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	
	// 이곳에 이미지

	@Column(nullable = false, length = 60000)
	@Lob
	private String content;
	private String location;
	private Timestamp createDate;
	private String emotion;

}
