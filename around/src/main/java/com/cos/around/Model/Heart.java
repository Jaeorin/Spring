package com.cos.around.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "userNum", "replyNum" }),
		@UniqueConstraint(columnNames = { "userNum", "boardNum" }) })
@Data
@Entity
//@JsonIdentityInfo(generator =  ObjectIdGenerators.IntSequenceGenerator.class)
public class Heart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int heartNum;

	@JsonIgnoreProperties({ "bookMark", "subscribe", "userGender", "userAge", "userSearchRegion", "userRegion",
			"userEmail", "userSearchMinAge", "userSearchMaxAge", "userActivate", "userCreateDate", "userUpdateDate",
			"heart", "reply", "board" })
	@ManyToOne
	@JoinColumn(name = "userNum")
	private Users user;

	@JsonIgnoreProperties({ "bookMark", "attachFile", "attachSearch", "boardContent", "boardCreateDate",
			"boardUpdateDate", "user", "boardRegion", "feeling", "heart", "reply", "insertTag" })
	@ManyToOne
	@JoinColumn(name = "boardNum")
	private Board board;

	@JsonIgnoreProperties({ "replyContent", "replyStatus", "replyCreateDate", "replyUpdateDate", "board", "toReply",
			"user", "heart" })
	@ManyToOne
	@JoinColumn(name = "replyNum")
	private Reply reply;

	// 0 board, 1 reply
	@Column(nullable = false)
	private int heartStatus;

	@CreationTimestamp
	private LocalDate heartCreateDate;
	@CreationTimestamp
	private LocalDate heartUpdateDate;
}
