package com.ty.recruitment.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ty.recruitment.common.entity.CommonEntity;
import com.ty.recruitment.utils.ListToStringConverter;

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
public class CandidateInfo extends CommonEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long candidateId;
	private String candidateName;
	private String email;
	private String mobileNumber;
	@Convert(converter = ListToStringConverter.class)
	private Set<String> skillSet;
	private Boolean relocation;
	private Double yearOfExperiance;
	@Column(name = "current_ctc")
	private String currentCTC;
	@Column(name = "expected_ctc")
	private String expectedCTC;
	private Long noticePeriod;
	private String status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resume_id")
	private CandidateResumeInfo candidateResumeInfo;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "candidate_id")
	private List<CandidateFeedbackDetails> candidateFeedbackDetails;

}
