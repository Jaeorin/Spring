package com.cos.costagram.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
public class FollowDto {

	private int id;
	private User fromUser;
	private User toUser;
	private String matpal;
	private LocalDate createDate;
	private LocalDate updateDate;

}
