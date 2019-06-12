package com.cos.around.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class WebPage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@CreationTimestamp
	private LocalDate createDate;
	@CreationTimestamp
	private LocalDate updateDate;
	
	@JsonIgnoreProperties({ "bookMark", "attachFile", "attachSearch", "boardContent", "boardCreateDate",
			"boardUpdateDate", "user", "boardRegion", "feeling", "heart", "reply", "insertTag" })
	@ManyToOne
	@JoinColumn(name = "boardNum")
	private Board board;
	private String title;
	
	@Enumerated(EnumType.STRING)
	private WebCategory webCategory;
		
}
