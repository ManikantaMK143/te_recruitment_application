package com.ty.recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.recruitment.entity.CandidateInfo;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateInfo, Long> {

}
