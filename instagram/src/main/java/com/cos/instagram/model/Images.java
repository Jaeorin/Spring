package com.cos.instagram.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Images {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Lob
	@Column(length=1024000)
	private byte[] file;
	private String location;
	private String caption;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user;
	
	@OneToMany
	@JoinColumn(name="image_id")
	private List<Tags> tags;
	
	private Timestamp create_date;
	private Timestamp update_date;
	
}
