package com.cos.around.Model;

import lombok.Data;

@Data

public class HeartDTO {

	private int heartNum;

	private UsersDTO userDTO;

	private BoardDTO boardDTO;

	private ReplyDTO replyDTO;

	private int heartStatus;
}
