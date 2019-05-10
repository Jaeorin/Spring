package com.cos.instagram.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String username;
	private String name;
	private String website;
	private String bio;
	private String email;
	private String phone;
	private String gender;
	@Lob
	private byte[] profile;
	
//	@OneToMany(mappedBy = "from_user")
//	private Follow from_user;
//	@OneToMany(mappedBy = "to_user")
//	private Follow to_user;
	
	private Timestamp create_date;
	private Timestamp update_date;

}
