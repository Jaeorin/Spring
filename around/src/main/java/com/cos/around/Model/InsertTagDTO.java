package com.cos.around.Model;

import lombok.Data;

@Data

public class InsertTagDTO {
	private int insertTagNum;

	private TagsDTO tagDTO;
	private BoardDTO boardDTO;
}
