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
	@JoinColumn(name="from_user_id")
	private Users from_user;
	
	@ManyToOne
	@JoinColumn(name="to_user_id")
	private Users to_user;
	
	private Timestamp create_date;
	private Timestamp update_date;

}
