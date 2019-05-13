package com.cos.eround.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.eround.model.Eround;
import com.cos.eround.repository.EroundRepository;

@Service
public class EroundService {

	@Autowired
	private EroundRepository eroundRepository;
	
	public Eround create(Eround eround) {
		
		return eroundRepository.save(eround);
		
	}
	
	public Optional<Eround> findById(int num) {
		
		return eroundRepository.findById(num);
		
	}
	
}
