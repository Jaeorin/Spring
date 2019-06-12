package com.around.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.around.admin.model.Question;

public interface QuestionRepository extends JpaRepository<Question , Integer>{

}
