package com.cos.costagram.model;

import java.time.LocalDate;

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
