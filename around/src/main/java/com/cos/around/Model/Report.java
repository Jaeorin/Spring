package com.cos.around.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(
		uniqueConstraints = {
				@UniqueConstraint(
						columnNames = {
								"userNum", "boardNum" 
						}
				)
		}
)
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportNum;
	
	@ManyToOne
	@JsonIgnoreProperties({ "bookMark", "subscribe", "userGender", "userAge", "userSearchRegion", "userRegion",
		"userEmail", "userSearchMinAge", "userSearchMaxAge", "userActivate", "userCreateDate", "userUpdateDate",
		"heart", "reply", "board" })
	@JoinColumn(name = "userNum")
	private Users user;
	
	@ManyToOne
	@JsonIgnoreProperties({ "bookMark", "attachFile", "attachSearch", "boardContent", "boardCreateDate",
		"boardUpdateDate", "user", "boardRegion", "feeling", "heart", "reply", "insertTag" })
	@JoinColumn(name = "boardNum")
	private Board board;
	
}
