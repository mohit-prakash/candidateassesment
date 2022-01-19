package com.candidate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.candidate.entity.CandidatesInfo;

public interface CandidatesRepository extends JpaRepository<CandidatesInfo, Integer> {

}
