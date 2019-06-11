package com.cos.around.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
//@JsonIdentityInfo(generator =  ObjectIdGenerators.IntSequenceGenerator.class)
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int replyNum;

	@Column(nullable = false, length = 60)
	private String replyContent;
	@Column(nullable = false)
	private int replyStatus;
	@CreationTimestamp
	private LocalDate replyCreateDate;
	@CreationTimestamp
	private LocalDate replyUpdateDate;

	@JsonIgnoreProperties({ "bookMark", "attachFile", "attachSearch", "boardContent", "boardCreateDate",
			"boardUpdateDate", "user", "boardRegion", "feeling", "heart", "reply", "insertTag" })
	@ManyToOne
	@JoinColumn(name = "boardNum")
	private Board board;

	@JsonIgnoreProperties({ "replyContent", "replyStatus", "replyCreateDate", "replyUpdateDate", "board", "toReply",
			"heart", "user" })
	@ManyToOne
	@JoinColumn(name = "toReplyNum")
	private Reply toReply;

	@JsonIgnoreProperties({ "bookMark", "subscribe", "userGender", "userAge", "userSearchRegion", "userRegion",
			"userEmail", "userSearchMinAge", "userSearchMaxAge", "userActivate", "userCreateDate", "userUpdateDate",
			"heart", "reply", "board" })
	@ManyToOne
	@JoinColumn(name = "userNum")
	private Users user;

	@OneToMany(mappedBy = "reply")
	private List<Heart> heart;

}
