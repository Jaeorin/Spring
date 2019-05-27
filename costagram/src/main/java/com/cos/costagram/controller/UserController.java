package com.cos.costagram.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.costagram.model.Follow;
import com.cos.costagram.model.Image;
import com.cos.costagram.model.Likes;
import com.cos.costagram.model.User;
import com.cos.costagram.repository.FollowRepository;
import com.cos.costagram.repository.ImageRepository;
import com.cos.costagram.repository.LikesRepository;
import com.cos.costagram.repository.UserRepository;
import com.cos.costagram.service.CustomUserDetails;

@Controller
public class UserController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LikesRepository likesRepository;
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private FollowRepository followRepository;
	
	@GetMapping("/")
	public String home() {
		return "/auth/join";
	}
	
	@GetMapping("/auth/login")
	public String authLogin() {
		return "/auth/login";
	}
	
	@GetMapping("/auth/join")
	public String authJoin() {
		return "/auth/join";
	}
	
	@PostMapping("/auth/create")
	public String create(User user) {
		String rawPassword = user.getPassword();
		String encPassword = passwordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		userRepository.save(user);
		return "/auth/login";
	}
	
	@GetMapping("/explore")
	public String explore() {
		return "/user/explore";
	}
	
	@GetMapping("/user/{id}")
	public @ResponseBody Model userDetail(@PathVariable int id, @AuthenticationPrincipal CustomUserDetails userDetail, Model model) {
		
		
		// 접속한 유저(세션에 있는 유저디테일) 정보 - user
		Optional<User> userO = userRepository.findById(userDetail.getUser().getId());
		User user = userO.get();
		
		// 현재 페이지({id})의 유저 정보 - imageUser
		Optional<User> imageUserO = userRepository.findById(id);
		User imageUser = imageUserO.get();
		
		// 이미지 리스트 + 이미지 카운트 + 좋아요 카운트
		// - imageList, imageCount
		List<Image> imageList = imageRepository.findByUserIdOrderByCreateDateDesc(imageUser.getId());
		int imageCount = imageList.size();
		for(Image i : imageList) {
			List<Likes> likeList = likesRepository.findByImageId(i.getId());
			i.setLikeCount(likeList.size());
		}
		
		// 팔로우 카운트 - followCount
		List<Follow> followList = followRepository.findByFromUserId(id);
		int followCount = followList.size();
		
		// 팔로워 카운트 - followerCount
		List<Follow> followerList = followRepository.findByToUserId(id);
		int followerCount = followerList.size();
		
		model.addAttribute("user", user);
		model.addAttribute("imageUser", imageUser);
		model.addAttribute("imageList", imageList);
		model.addAttribute("imageCount", imageCount);
		model.addAttribute("followCount", followCount);
		model.addAttribute("followerCount", followerCount);
		
		return model;
	}
	
	
}
