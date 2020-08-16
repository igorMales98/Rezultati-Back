package com.scores.mapper;

import com.scores.dto.KlubDTO;
import com.scores.model.Klub;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class KlubDTOMapper implements MapperInterface<Klub, KlubDTO> {

    private ModelMapper modelMapper;

    @Override
    public Klub toEntity(KlubDTO dto) throws ParseException {
        return modelMapper.map(dto, Klub.class);
    }

    @Override
    public KlubDTO toDto(Klub entity) {
        return modelMapper.map(entity, KlubDTO.class);
    }

    @Autowired
    public KlubDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
