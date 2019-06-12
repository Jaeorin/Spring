package com.around.admin.model;

import java.util.List;

import lombok.Data;

@Data
public class PagingListDTO<E> {
	private List<E> list;
	private int maxPage;
	private int page;
	
}
