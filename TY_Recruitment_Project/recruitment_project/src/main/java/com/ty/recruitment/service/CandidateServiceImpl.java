package com.ty.recruitment.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.recruitment.common.dto.CandidateFeedbackInfoDto;
import com.ty.recruitment.common.dto.CandidateInfoDto;
import com.ty.recruitment.common.dto.CandidateResumeDTO;
import com.ty.recruitment.entity.CandidateFeedbackDetails;
import com.ty.recruitment.entity.CandidateInfo;
import com.ty.recruitment.entity.CandidateResumeInfo;
import com.ty.recruitment.repository.CandidateRepository;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public CandidateInfoDto save(CandidateInfoDto candidateInfoDto) {
		if (candidateInfoDto.getCandidateId() == null) {
			CandidateInfo candidateInfo = new CandidateInfo();
			BeanUtils.copyProperties(candidateInfoDto, candidateInfo);
			Set<String> skillSet = candidateInfoDto.getSkillSet();
			candidateInfo.setSkillSet(skillSet);

			CandidateResumeDTO candidateResumeDTO = candidateInfoDto.getCandidateResumeDTO();
			System.err.println(candidateResumeDTO.toString());
			CandidateResumeInfo candidateResumeInfo = new CandidateResumeInfo();
			BeanUtils.copyProperties(candidateResumeDTO, candidateResumeInfo);
			candidateInfo.setCandidateResumeInfo(candidateResumeInfo);

			CandidateFeedbackDetails candidateFeedbackDetails = new CandidateFeedbackDetails();
			System.err.println(candidateFeedbackDetails.toString());
			List<CandidateFeedbackInfoDto> candidateFeedbackInfoDto = candidateInfoDto.getCandidateFeedbackInfoDto();
			for (CandidateFeedbackInfoDto c : candidateFeedbackInfoDto) {
				BeanUtils.copyProperties(c, candidateFeedbackDetails);
			}

			CandidateInfo save = candidateRepository.save(candidateInfo);
			candidateInfoDto.setSkillSet(save.getSkillSet());
			candidateInfoDto.setCandidateFeedbackInfoDto(candidateFeedbackInfoDto);
			return candidateInfoDto;
		} else {

		}
		return candidateInfoDto;
	}

}
