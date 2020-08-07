package com.scores.mapper;

import com.scores.dto.SportDTO;
import com.scores.model.Sport;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class SportDTOMapper implements MapperInterface<Sport, SportDTO> {

    private ModelMapper modelMapper;

    @Override
    public Sport toEntity(SportDTO dto) throws ParseException {
        return modelMapper.map(dto, Sport.class);
    }

    @Override
    public SportDTO toDto(Sport entity) {
        return modelMapper.map(entity, SportDTO.class);
    }

    @Autowired
    public SportDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
