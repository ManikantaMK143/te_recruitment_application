package com.ty.recruitment.service;

import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.ty.recruitment.common.dto.CandidateResumeDTO;

public interface ResumeFileUploadService {
	
	public CandidateResumeDTO uploadFile(MultipartFile multipartFile);

	public Resource downloadFile(Long id, HttpServletRequest request) throws MalformedURLException ;

}
