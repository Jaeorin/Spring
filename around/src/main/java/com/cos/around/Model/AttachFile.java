package com.cos.around.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
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
public class AttachFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int attachNum;

	private String mimeType;
	private String fileName;
	private String filePath;

	@JsonIgnoreProperties({ "bookMark", "attachFile", "attachSearch", "boardContent", "boardCreateDate",
			"boardUpdateDate", "user", "boardRegion", "feeling", "heart", "reply", "insertTag" })
	@ManyToOne
	@JoinColumn(name = "boardNum")
	private Board board;

	@CreationTimestamp
	private LocalDate attachCreateDate;
	@CreationTimestamp
	private LocalDate attachUpdateDate;

}
