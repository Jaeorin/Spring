package com.cos.around.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
//@JsonIdentityInfo(generator =  ObjectIdGenerators.IntSequenceGenerator.class)
public class InsertTag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int insertTagNum;

	@JsonIgnoreProperties({ "tagCreateDate", "tagUpdateDate", "insertTag", "subscribe" })
	@ManyToOne
	@JoinColumn(name = "tagNum")
	private Tags tag;

	@JsonIgnoreProperties({ "bookMark", "attachFile", "attachSearch", "boardContent", "boardCreateDate",
			"boardUpdateDate", "user", "boardRegion", "feeling", "heart", "reply", "insertTag" })
	@ManyToOne
	@JoinColumn(name = "boardNum")
	private Board board;
	

	@CreationTimestamp
	private LocalDate insertTagCreateDate;
	@CreationTimestamp
	private LocalDate insertTagUpdateDate;
}
