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
public class BookMark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookMarkNum;

	@JsonIgnoreProperties({ "bookMark","attachFile", "attachSearch", "boardContent", "boardCreateDate", "boardUpdateDate", "user",
			"boardRegion", "feeling", "heart", "reply", "insertTag" })
	@ManyToOne
	@JoinColumn(name = "boardNum")
	private Board board;

	@JsonIgnoreProperties({ "bookMark", "subscribe", "userGender", "userAge", "userSearchRegion", "userRegion",
			"userEmail", "userSearchMinAge", "userSearchMaxAge", "userActivate", "userCreateDate", "userUpdateDate",
			"heart", "reply", "board" })
	@ManyToOne
	@JoinColumn(name = "userNum")
	private Users user;

	@CreationTimestamp
	private LocalDate bookMarkCreateDate;
	@CreationTimestamp
	private LocalDate bookMarkUpdateDate;
}
