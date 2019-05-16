package com.cos.instagram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cos.instagram.model.Users;
import com.cos.instagram.repogitory.UserRepogitory;

public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepogitory userRepogitory;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		Users user = userRepogitory.findByUsername(username);
		CustomUserDetails userDetails = null;

		if (user != null) {

			userDetails = new CustomUserDetails();
			userDetails.setUser(user);

		} else {

			throw new UsernameNotFoundException("유저를 찾을 수 없습니다" + username);
			
		}

		return userDetails;

	}

}
