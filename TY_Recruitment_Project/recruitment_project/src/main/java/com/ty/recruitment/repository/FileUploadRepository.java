package com.ty.recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.recruitment.entity.CandidateResumeInfo;
@Repository
public interface FileUploadRepository extends JpaRepository<CandidateResumeInfo, Long> {

}
