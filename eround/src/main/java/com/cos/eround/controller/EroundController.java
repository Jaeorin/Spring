package com.cos.eround.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.eround.model.Eround;
import com.cos.eround.service.EroundService;

@RestController
@RequestMapping("/eround")
public class EroundController {

	@Autowired
	private EroundService eroundService;

	@RequestMapping("/test")
	public Map<String, String> androidRequest(HttpServletRequest request){

		int num = Integer.parseInt(request.getParameter("num"));
		
		Map<String, String> result = new HashMap<String, String>();

		Optional<Eround> eround = eroundService.findById(num);
		Eround eround2 = eround.get();

        result.put("content", eround2.getContent());
        result.put("createDate", eround2.getCreateDate().toString());
        result.put("emotion", eround2.getEmotion());
        result.put("location", eround2.getLocation());

        return result;
	}

}
