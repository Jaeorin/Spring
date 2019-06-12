package com.around.admin.model;

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
public class Question implements Comparable<Question>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@CreationTimestamp
	private LocalDate createDate;
	@CreationTimestamp
	private LocalDate updateDate;

	@JsonIgnoreProperties({ "bookMark", "subscribe", "userGender", "userAge", "userSearchRegion", "userRegion",
			"userEmail", "userSearchMinAge", "userSearchMaxAge", "userActivate", "userCreateDate", "userUpdateDate",
			"heart", "reply", "board" })
	@ManyToOne
	@JoinColumn(name = "userNum")
	private Users user;
	
	private String title;
	
	private String content;
	
	@Override
	public int compareTo(Question board) {
			long time1 = Integer.parseInt(this.createDate.toString().replaceAll("-", ""));
			long time2 = Integer.parseInt(board.getCreateDate().toString().replaceAll("-", ""));
			if(time1 < time2) {
				return -1;
			}else if(time1 > time2) {
				return 1;
			}
			return 0;
		}
}
