package com.ty.recruitment.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateFeedbackInfoDto {

	private Long feedbackId;
	private String companyName;
	private Long roundNumber;
	private String feedbackRemarks;
	private Boolean status;
	private Boolean IsBlocked;
}
