package com.assessment.converter;

import com.assessment.dto.ResultDTO;
import com.assessment.entity.Result;

public class ResultConverter {

    public static Result dtoToEntity(ResultDTO resultDto) {
        return new Result(resultDto.getCourse(), resultDto.getStudent(), resultDto.getScore());
    }

    public static ResultDTO entityToDto(Result result) {
        return new ResultDTO(result.getCourse(), result.getStudent(), result.getScore());
    }

}
