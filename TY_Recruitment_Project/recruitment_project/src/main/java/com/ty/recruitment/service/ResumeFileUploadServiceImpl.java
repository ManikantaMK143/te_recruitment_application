package com.ty.recruitment.service;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ty.recruitment.common.dto.CandidateResumeDTO;
import com.ty.recruitment.entity.CandidateResumeInfo;
import com.ty.recruitment.repository.FileUploadRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ResumeFileUploadServiceImpl implements ResumeFileUploadService {

	@Autowired
	FileUploadRepository fileUploadRepository;

	@Override
	public CandidateResumeDTO uploadFile(MultipartFile multipartFile) {
		CandidateResumeDTO resumeDTO = null;
		String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		String contentType = multipartFile.getContentType();
		
		log.info("Uploading the ");

		try {

			if (!filename.contains("..")) {

				if (contentType != null && contentType.contains("application/pdf") || contentType != null && contentType
						.contains("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {

					File newFolder = new File("C:\\Temp_Floder");
					if (!newFolder.exists()) {
						newFolder.mkdirs();
					}

					
					Path destinationPath = newFolder.toPath().resolve(filename);

					Files.copy(multipartFile.getInputStream(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

					CandidateResumeInfo fileEntity = new CandidateResumeInfo();
					fileEntity.setFileName(filename);
					fileEntity.setContentType(multipartFile.getContentType());
					fileEntity.setPath(newFolder.getPath() + "\\" + filename);

					CandidateResumeInfo save = fileUploadRepository.save(fileEntity);

					resumeDTO = new CandidateResumeDTO();
					BeanUtils.copyProperties(save, resumeDTO);
				} else {
					throw new RuntimeException("Invalid file");
				}
			} else {
				throw new RuntimeException("Sorry! File name which contains invalid path sequence " + filename);
			}

		} catch (Exception e) {
			log.error("Exception occured at ", e);
		}

		return resumeDTO;
	}

	@Override
	public Resource downloadFile(Long id, HttpServletRequest request) throws MalformedURLException {
		Resource urlResource = null;
		try {
			CandidateResumeInfo candidateResumeDetails = fileUploadRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Invalid file id"));
			urlResource = new UrlResource(Paths.get(candidateResumeDetails.getPath()).toUri());

			if (!urlResource.exists() || !urlResource.isReadable()) {
				throw new RuntimeException("File not found or not readable");
			}

		} catch (Exception e) {
			log.error("Exception occured at ", e);
		}

		return urlResource;

	}

}
