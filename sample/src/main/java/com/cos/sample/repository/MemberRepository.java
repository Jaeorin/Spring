package com.cos.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.sample.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
