package com.cos.around.Model;

import java.sql.Timestamp;

import lombok.Data;

@Data

public class BoardDTO {

	private int boardNum;

	private String boardContent;

	private String boardAttach;

	private Timestamp boardCreateDate;

	private Timestamp boardUpdateDate;

	private Region boardRegion;

	private Users user;

	private FeelingDTO feeling;

}
