package com.scores.controller;

import com.scores.dto.ZemljaDTO;
import com.scores.mapper.ZemljaDTOMapper;
import com.scores.service.ZemljaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/zemlja", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZemljaController {

    private ZemljaService zemljaService;
    private ZemljaDTOMapper zemljaDTOMapper;

    @Autowired
    public ZemljaController(ZemljaService zemljaService, ZemljaDTOMapper zemljaDTOMapper) {
        this.zemljaService = zemljaService;
        this.zemljaDTOMapper = zemljaDTOMapper;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<ZemljaDTO>> getAll() {
        try {
            List<ZemljaDTO> zemljaDTOS = this.zemljaService.getAll().stream().map(zemljaDTOMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(zemljaDTOS, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
