package com.scores.mapper;

import com.scores.dto.IgracDTO;
import com.scores.model.Igrac;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class IgracDTOMapper implements MapperInterface<Igrac, IgracDTO> {

    private ModelMapper modelMapper;

    @Override
    public Igrac toEntity(IgracDTO dto) throws ParseException {
        return modelMapper.map(dto, Igrac.class);
    }

    @Override
    public IgracDTO toDto(Igrac entity) {
        return modelMapper.map(entity, IgracDTO.class);
    }

    @Autowired
    public IgracDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
