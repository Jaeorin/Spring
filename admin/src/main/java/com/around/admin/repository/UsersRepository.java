package com.around.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.around.admin.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

}
