package com.ty.recruitment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.recruitment.common.dto.CandidateInfoDto;
import com.ty.recruitment.common.dto.ResponseDTO;
import com.ty.recruitment.service.CandidateService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@RequestMapping("api/v1/")
@Slf4j
@RestController
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	@PostMapping("/save")
	public ResponseEntity<ResponseDTO> save(@RequestBody CandidateInfoDto candidateInfoDto) {
		log.info("inside save candidate");
		return new ResponseEntity<ResponseDTO>(
				new ResponseDTO(false, candidateService.save(candidateInfoDto), "Saved Succesfully"),
				HttpStatus.CREATED);
	}

}
