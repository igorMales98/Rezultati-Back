package com.scores.mapper;

import com.scores.dto.SezonaDTO;
import com.scores.model.Sezona;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class SezonaDTOMapper implements MapperInterface<Sezona, SezonaDTO> {

    private ModelMapper modelMapper;

    @Override
    public Sezona toEntity(SezonaDTO dto) throws ParseException {
        return modelMapper.map(dto, Sezona.class);
    }

    @Override
    public SezonaDTO toDto(Sezona entity) {
        return modelMapper.map(entity, SezonaDTO.class);
    }

    @Autowired
    public SezonaDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
