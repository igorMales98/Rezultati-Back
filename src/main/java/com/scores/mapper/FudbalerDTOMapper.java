package com.scores.mapper;

import com.scores.dto.FudbalerDTO;
import com.scores.model.Fudbaler;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class FudbalerDTOMapper implements MapperInterface<Fudbaler, FudbalerDTO> {

    private ModelMapper modelMapper;

    @Override
    public Fudbaler toEntity(FudbalerDTO dto) throws ParseException {
        return modelMapper.map(dto, Fudbaler.class);
    }

    @Override
    public FudbalerDTO toDto(Fudbaler entity) {
        return modelMapper.map(entity, FudbalerDTO.class);
    }

    @Autowired
    public FudbalerDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
