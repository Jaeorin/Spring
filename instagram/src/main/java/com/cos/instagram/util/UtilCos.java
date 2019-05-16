package com.cos.instagram.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cos.instagram.model.Users;

public class UtilCos {
	
//	@Autowired
//	private static BCryptPasswordEncoder passwordEncoder;

	public static String getResourcePath() {

		return "C://Workspace//Spring//instagram//src//main//resources//static//image//";

	}

	public static Users getUser() {
		
//		String password = passwordEncoder.encode("1234");
//		System.out.println("password" + password);

		Users user = Users.builder()
				.bio("cos에 인스타에요")
				.email("cos@naver.com")
				.gender("남")
				.name("최재원")
				.phone("010-2222-5555")
				.username("cos")
				.password("1234")
				.website("http://blig.naver.com")
				.createDate(LocalDate.now())
				.updateDate(LocalDate.now())
				.build();

		return user;

	}

	public static List<String> tagParser(String tags) {

		String temp[] = tags.split("#");

		List<String> tagList = new ArrayList<String>();

		int len = temp.length;

		for (int i = 1; i < len; i++) {

			tagList.add(temp[i]);
			
		}

		return tagList;

	}

}
