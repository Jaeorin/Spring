package com.cos.instagram.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/*
 * @JsonIgnore를 사용하면 해당 객체를 참조하지 않는다 
 */

@Data
@Entity
public class Tags {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	@JsonIgnoreProperties({"username", "name", "website", "bio", "email", "phone", "gender", "createDate", "updateDate"})
	private Users user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "imageId")
	@JsonBackReference
	private Images image;
	
	@CreationTimestamp
	private LocalDate createDate;
	@CreationTimestamp
	private LocalDate updateDate;

	// 이렇게 하면 시리어라이저블(직렬화)이 되지 않는다
//	public Images getImage() {
//		return null;
//	}
	
}
