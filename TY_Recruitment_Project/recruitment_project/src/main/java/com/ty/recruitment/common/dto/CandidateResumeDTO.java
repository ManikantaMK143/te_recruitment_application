package com.ty.recruitment.common.dto;

import com.ty.recruitment.common.entity.CommonEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResumeDTO{
	
	private Long resumeId;
	private String fileName;
	private String contentType;
	private String path;

}
