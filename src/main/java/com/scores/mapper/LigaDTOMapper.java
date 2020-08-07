package com.scores.mapper;

import com.scores.dto.LigaDTO;
import com.scores.model.Liga;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class LigaDTOMapper implements MapperInterface<Liga, LigaDTO> {

    private ModelMapper modelMapper;

    @Override
    public Liga toEntity(LigaDTO dto) throws ParseException {
        return modelMapper.map(dto, Liga.class);
    }

    @Override
    public LigaDTO toDto(Liga entity) {
        return modelMapper.map(entity, LigaDTO.class);
    }

    @Autowired
    public LigaDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
