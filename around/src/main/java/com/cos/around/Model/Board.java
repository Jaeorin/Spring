package com.cos.around.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
//@JsonIdentityInfo(generator =  ObjectIdGenerators.IntSequenceGenerator.class)
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boardNum;

	@Lob
	@Column(nullable = false)
	private String boardContent;

	@CreationTimestamp
	private LocalDate boardCreateDate;
	@CreationTimestamp
	private LocalDate boardUpdateDate;

	@JsonIgnoreProperties({ "bookMark", "subscribe", "userGender", "userAge", "userSearchRegion", "userRegion",
			"userEmail", "userSearchMinAge", "userSearchMaxAge", "userActivate", "userCreateDate", "userUpdateDate",
			"heart", "reply", "board" })
	@ManyToOne
	@JoinColumn(name = "userNum")
	private Users user;

	
	@Enumerated(EnumType.STRING)
	private Region boardRegion;

	@JsonIgnoreProperties({ "feelingCreateDate", "feelingUpdateDate", "board" })
	@ManyToOne
	@JoinColumn(name = "feelingNum")
	private Feeling feeling;

	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
	private List<Heart> heart;

	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
	private List<Reply> reply;

	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
	private List<InsertTag> insertTag;

	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
	private List<AttachFile> attachFile;

	private String attachSearch;
	
	private int reportCount;
}
