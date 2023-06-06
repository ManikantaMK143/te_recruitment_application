package com.ty.recruitment.common.dto;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateInfoDto {
	
	private Long candidateId;
	private String candidateName;
	private String email;
	private String mobileNumber;
	private Set<String> skillSet;
	private Boolean relocation;
	private Double yearOfExperiance;
	private String currentCTC;
	private String expectedCTC;
	private Long noticePeriod;
	private String status;
	
	private CandidateResumeDTO candidateResumeDTO;
	
	private List<CandidateFeedbackInfoDto> candidateFeedbackInfoDto;
	
	

}
