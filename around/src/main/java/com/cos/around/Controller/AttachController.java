package com.cos.around.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cos.around.Model.AttachFile;
import com.cos.around.Model.Board;
import com.cos.around.Repository.AttachFileRepository;

@RestController
@RequestMapping("/attach")
public class AttachController {

	private final String PATH = "E://around!//around-master//src//main//resources//static//attach//";
	@Autowired
	private AttachFileRepository attachFileRepository;

	@PostMapping("/save")
	public String attachUpload(@RequestParam("file") List<MultipartFile> file, int boardNum) throws IOException {
		int len = file.size();
		List<AttachFile> aFiles = new ArrayList<AttachFile>();
		for (int i = 0; i < len; i++) 
		{
			
			String extName
			= file.get(i).getOriginalFilename().substring(file.get(i).getOriginalFilename().lastIndexOf("."), file.get(i).getOriginalFilename().length());
			String fileName = "around_" + boardNum + "_" + LocalDate.now() + "_" +00+ i+extName;
			Path filePath = Paths.get(PATH + fileName);
			
			Files.write(filePath, file.get(i).getBytes());
			
			AttachFile aFile = new AttachFile();
			aFile.setMimeType(file.get(i).getContentType());
			aFile.setFileName(fileName);
			aFile.setFilePath("/attach/" + fileName);
			aFile.setBoard(new Board());
			aFile.getBoard().setBoardNum(boardNum);
			aFiles.add(aFile);
		}
		attachFileRepository.saveAll(aFiles);
		return "Ok";
	}
	
	@PostMapping("/deleteall")
	public int attachAllDelete(int boardNum){
		
		List<AttachFile> attachs= attachFileRepository.findByBoardBoardNum(boardNum);
		int len= attachs.size();
		try {
			for(AttachFile attach : attachs) {
				Path filePath= Paths.get(attach.getFilePath());
				Files.delete(filePath);
			}
			attachFileRepository.deleteAll(attachs);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
			return len;
	}
	@PostMapping("/update")
	public String attachUpdate(@RequestParam("file") List<MultipartFile> file, int boardNum) throws IOException {
		List<AttachFile> attachs= attachFileRepository.findByBoardBoardNum(boardNum);
		attachAllDelete(boardNum);
		int len = file.size();
		List<AttachFile> aFiles = new ArrayList<AttachFile>();
		for (int i = 0; i < len; i++) 
		{
			
			String extName
			= file.get(i).getOriginalFilename().substring(file.get(i).getOriginalFilename().lastIndexOf("."), file.get(i).getOriginalFilename().length());
			String fileName = "around_" + boardNum + "_" + LocalDate.now() + "_" +00+ i+extName;
			Path filePath = Paths.get(PATH + fileName);
			
			Files.write(filePath, file.get(i).getBytes());
			
			AttachFile aFile = new AttachFile();
			if(attachs.get(i)!= null) {
			aFile.setAttachNum(attachs.get(i).getAttachNum());}
			aFile.setMimeType(file.get(i).getContentType());
			aFile.setFileName(fileName);
			aFile.setFilePath("/attach/" + fileName);
			aFile.setBoard(new Board());
			aFile.getBoard().setBoardNum(boardNum);
			aFiles.add(aFile);
		}
		attachFileRepository.saveAll(aFiles);
		return "Ok";
	}
}
