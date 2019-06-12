package com.around.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.around.admin.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
