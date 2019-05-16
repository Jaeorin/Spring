package com.cos.instagram.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/image/upload")
	public Images imageUpload(@RequestParam("file") MultipartFile file,
			String caption, String location, String tags) throws IOException {

		Path filePath = Paths.get(UtilCos.getResourcePath()
			+ file.getOriginalFilename());
		
		System.out.println(context + filePath);

		Files.write(filePath, file.getBytes());

		Users user = UtilCos.getUser();
		
		String password = user.getPassword();
		
		String encPassword = passwordEncoder.encode(password);
		user.setPassword(encPassword);
		List<String> tagList = UtilCos.tagParser(tags);

		// user객체가 db에 flush되지 않으면 image를 save할 수 없음
		userRepogitory.save(user);

		Images image = Images.builder()
				.caption(caption)
				.location(location)
				.user(user)
				.mimeType(file.getContentType())
				.fileName(file.getOriginalFilename())
				.filepath("/image/" + file.getOriginalFilename())
				.build();

		imageRepogitory.save(image);

		for (String t : tagList) {

			Tags tag = new Tags();
			tag.setName(t);
			tag.setImage(image);
			tag.setUser(user);

			tagRepogitory.save(tag);
			image.getTags().add(tag); // DB에 영향을 미치지 않음

		}

		return image;

	}

	@GetMapping("/image/{id}")
	public Images imageDetail(@PathVariable int id) {

		Optional<Images> imageOptional = imageRepogitory.findById(id);
		if (imageOptional.isPresent()) {
			Images image = imageOptional.get();
			image.getTags();
			return image;
		} else {
			return null;
		}

	}
	
	@GetMapping("/images")
	public List<Images> images(){
		
		List<Images> list = imageRepogitory.findAll();
		
		return list;
		
	}
	
	@GetMapping("/image/page")
	public Page<Images> imageList(@PageableDefault(sort = {"id"}, direction = Direction.DESC, size = 5) Pageable pageable){
		
		Page<Images> list = imageRepogitory.findAll(pageable);

		return list;
		
	}
	
	@GetMapping("/tag")
	public List<Tags> tag(String name) {

		return tagRepogitory.findByNameContaining(name);

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
