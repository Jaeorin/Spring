package com.cos.instagram.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cos.instagram.model.Images;
import com.cos.instagram.model.Tags;
import com.cos.instagram.model.Users;
import com.cos.instagram.repogitory.ImageRepogitory;
import com.cos.instagram.repogitory.TagRepogitory;
import com.cos.instagram.repogitory.UserRepogitory;
import com.cos.instagram.util.UtilCos;

@RestController
public class TestImageController {

	private static final String context = "TestImageController : ";
			
	@Autowired
	private ImageRepogitory imageRepogitory;
	@Autowired
	private UserRepogitory userRepogitory;
	@Autowired
	private TagRepogitory tagRepogitory;
	
	
	@PostMapping("/image/upload")
	public Images imageUpload(@RequestParam("file") MultipartFile file, String caption, String location, String tags) throws IOException {
		
		Path filePath = Paths.get(UtilCos.getResourcePath() + file.getOriginalFilename());
		System.out.println(context + filePath);
		
		Files.write(filePath, file.getBytes());
		
		Users user = UtilCos.getUser();
		List<String> tagList = UtilCos.tagParser(tags);
		
		userRepogitory.save(user); // user객체가 db에 flush되지 않으면 image를 save할 수 없음
		
		Images image = Images.builder()
				.caption(caption)
				.location(location)
				.user(user)
				.mimeType(file.getContentType())
				.fileName(file.getOriginalFilename())
				.filepath("/image/" + file.getOriginalFilename())
				.build();
		
		imageRepogitory.save(image);
		
		for(String t: tagList) {
			
			Tags tag = new Tags();
			tag.setName(t);
			tag.setImage(image);
			tag.setUser(user);
			
			tagRepogitory.save(tag);
			image.getTags().add(tag); //DB에 영향을 미치지 않음
			
		}
		
		return image;
		
	}

	@PostMapping("/test/image/upload")
	public ResponseEntity<Resource> imageUpload(@RequestParam("file") MultipartFile file) throws IOException {

		System.out.println("getBytes : " + file.getBytes());
		System.out.println("getName : " + file.getName());
		System.out.println("getContentType : " + file.getContentType());
		System.out.println("getSize : " + file.getSize());
		System.out.println("getResource : " + file.getResource());
		System.out.println("getOriginalFilename : " + file.getOriginalFilename());

		Images image = new Images();
		// 숙제 1 : Bytes[] 파일 Insert 하는 방법
		// 숙제 2 : Tag 받기 다른 Image필드값 받기
		
//		image.setFile(file.getBytes());
		
		imageRepogitory.save(image);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getOriginalFilename() + "\"")
				.contentType(MediaType.parseMediaType(file.getContentType()))
				.body(new ByteArrayResource(file.getBytes()));

	}

}
