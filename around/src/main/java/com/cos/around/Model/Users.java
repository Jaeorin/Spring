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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
//@JsonIdentityInfo(generator =  ObjectIdGenerators.IntSequenceGenerator.class)
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userNum;
	@Column(nullable = false)
	private int userAge;
	@Column(nullable = false)
	private String userGender;

	@Enumerated(EnumType.STRING)
	private Region userSearchRegion;

	@Enumerated(EnumType.STRING)
	private Region userRegion;

	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Heart> heart;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<BookMark> bookMark;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Subscribe> subscribe;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Board> board;

	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Reply> reply;
	
	@Column(nullable = false, length = 50)
	private String userEmail;
	@Column(nullable = false)
	private int userSearchMinAge;
	@Column(nullable = false)
	private int userSearchMaxAge;
	@Column(nullable = false)
	private int userActivate;
	@CreationTimestamp
	private LocalDate userCreateDate;
	@CreationTimestamp
	private LocalDate userUpdateDate;
}
