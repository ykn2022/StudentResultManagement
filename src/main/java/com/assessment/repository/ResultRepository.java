package com.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.entity.Result;

@Repository
public interface ResultRepository extends ResultRepositoryCustom, JpaRepository<Result, Integer> {

}
