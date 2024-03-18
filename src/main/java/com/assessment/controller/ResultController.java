package com.assessment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.dto.ResultDTO;
import com.assessment.entity.Result;
import com.assessment.exception.DuplicateEntityException;
import com.assessment.service.impl.ResultServiceImpl;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    private final ResultServiceImpl service;

    public ResultController(ResultServiceImpl service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<ResultDTO>> getAllResults() {
        List<ResultDTO> results = service.findAll();
        return ResponseEntity.ok().body(results);
    }

    @PostMapping
    public ResponseEntity<ResultDTO> addResult(@Valid @RequestBody Result result) throws DuplicateEntityException {
        ResultDTO newResult = service.addResult(result);
        return ResponseEntity.ok().body(newResult);
    }
}
