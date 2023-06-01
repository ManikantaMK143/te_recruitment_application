package com.ty.recruitment.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ty.recruitment.common.entity.CommonEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CandidateFeedbackDetails extends CommonEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6362796643029952438L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedbackId;
	private String companyName;
	private Long roundNumber;
	private String feedbackRemarks;
	private Boolean status;
	private Boolean IsBlocked;

}
