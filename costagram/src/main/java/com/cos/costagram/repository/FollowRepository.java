package com.cos.costagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.costagram.model.Follow;

public interface FollowRepository extends JpaRepository<Follow, Integer> {

}
