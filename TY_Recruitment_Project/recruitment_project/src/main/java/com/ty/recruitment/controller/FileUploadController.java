package com.ty.recruitment.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ty.recruitment.common.dto.ResponseDTO;
import com.ty.recruitment.service.ResumeFileUploadService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("api/v1/recruitment")
@RestController
public class FileUploadController {

	@Autowired
	ResumeFileUploadService fileUploadService;

	@PostMapping("/upload-file")
	public ResponseEntity<ResponseDTO> uploadFile(@RequestParam("file") MultipartFile file) {
		log.info("Uploading Candidate Resume file::" + file.getOriginalFilename());
		return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder().isError(false)
				.data(fileUploadService.uploadFile(file)).message("File uploaded sucessfully").build());

	}

	@GetMapping("/download-file/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable Long id, HttpServletRequest request) throws IOException {

		Resource downloadFile = fileUploadService.downloadFile(id, request);
		String contentType = request.getServletContext().getMimeType(downloadFile.getFile().getAbsolutePath());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(contentType));
		headers.setContentDispositionFormData("attachment", downloadFile.getFilename());

		return ResponseEntity.ok().headers(headers).body(downloadFile);
	}

}
