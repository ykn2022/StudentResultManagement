package com.assessment.service;

import java.util.List;

import com.assessment.dto.ResultDTO;
import com.assessment.entity.Result;
import com.assessment.exception.DuplicateEntityException;

public interface IResultService {

    List<ResultDTO> findAll();
    ResultDTO addResult(Result result) throws DuplicateEntityException;
}
