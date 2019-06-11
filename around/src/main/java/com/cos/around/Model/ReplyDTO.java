package com.cos.around.Model;

import java.sql.Timestamp;

import lombok.Data;

@Data

public class ReplyDTO {

	private int replyNum;

	private String replyContent;

	private int replyStatus;

	private Timestamp replyCreateDate;

	private Timestamp replyUpdateDate;

	private BoardDTO boardDTO;
	private ReplyDTO toReplyDTO;
	private UsersDTO userDTO;

}
