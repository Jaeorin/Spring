package com.cos.instagram.repogitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.instagram.model.Users;

public interface UserRepogitory extends JpaRepository<Users, Integer>{

}
