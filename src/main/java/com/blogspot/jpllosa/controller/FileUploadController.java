package com.blogspot.jpllosa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@GetMapping("/")
	public String index() {
		return "upload";
	}
	
	@PostMapping("/")
	public ResponseEntity<String> handleFileUpload(
		@RequestParam("files") MultipartFile[] files) {

		for (MultipartFile file : files) {
			System.out.println(file.getOriginalFilename() 
				+ " " 
				+ file.getSize()
				+ " bytes");
		}

		// empty string means success
		return new ResponseEntity<>("", 
				HttpStatus.OK);
	}
}
