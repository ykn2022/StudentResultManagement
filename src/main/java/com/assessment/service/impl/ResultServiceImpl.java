package com.assessment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.converter.ResultConverter;
import com.assessment.dto.ResultDTO;
import com.assessment.entity.Result;
import com.assessment.exception.DuplicateEntityException;
import com.assessment.repository.ResultRepository;
import com.assessment.service.IResultService;

@Service
public class ResultServiceImpl implements IResultService {

    @Autowired
    ResultRepository resultRepository;

    @Override
    public List<ResultDTO> findAll() {
        return resultRepository.findAll()
                .stream()
                .map(ResultConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResultDTO addResult(Result result) throws DuplicateEntityException {
        List<Result> existingResults = resultRepository.findByCourseCourseIdAndStudentStudentId(result.getCourse().getCourseId(), result.getStudent().getStudentId());
        if (existingResults == null || existingResults.isEmpty()){
            Result newResult = resultRepository.save(result);
            return ResultConverter.entityToDto(newResult);
        } else {
            throw new DuplicateEntityException(Result.class.getSimpleName(), null);
        }
    }
}
