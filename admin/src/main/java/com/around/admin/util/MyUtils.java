package com.around.admin.util;

import java.util.Collections;
import java.util.List;

import com.around.admin.model.PagingListDTO;

public class MyUtils {
	public static <E extends Comparable<? super E>> PagingListDTO<E> paging(int page, List<E>  list  ){
		int maxPage = 0;
		int start = (page - 1) * 10;
		int end = page * 10;
		int mod = list.size() % 10; // 0
		if (mod == 0) {
			maxPage = list.size() / 10; // 2
		} else {
			maxPage = list.size() / 10 + 1;

			if (page == maxPage) {
				end = start + mod;
			}
		}

		System.out.println("=================");

		Collections.sort(list);

	
		if(list.size() > 10) {
		list = list.subList(start, end); // 0 3
		}
		PagingListDTO<E> pageList = new PagingListDTO<E>();
		pageList.setList(list);
		pageList.setMaxPage(maxPage);
		pageList.setPage(page);
		System.out.println("m:"+maxPage);
		System.out.println(page);
		return pageList;
	}

}
