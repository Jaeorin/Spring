package com.cos.instagram.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Follow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="from_user") // DB에 들어갈 포링 키(FK) 이름
	private Users from_user;
	
	@ManyToOne
	@JoinColumn(name="to_user") // DB에 들어갈 포링 키(FK) 이름
	private Users to_user;
	
	private Timestamp create_date;
	private Timestamp update_date;

}
