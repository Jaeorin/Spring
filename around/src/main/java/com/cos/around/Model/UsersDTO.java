package com.cos.around.Model;

import java.sql.Timestamp;

import lombok.Data;

@Data

public class UsersDTO {
	private int userNum;

	private int userAge;

	private String userGender;

	private Region userSearchRegion;

	private Region userRegion;

	private String userEmail;

	private int userSearchMinAge;

	private int userSearchMaxAge;

	private int userActivate;

	private Timestamp userCreateDate;

	private Timestamp userUpdateDate;
}
