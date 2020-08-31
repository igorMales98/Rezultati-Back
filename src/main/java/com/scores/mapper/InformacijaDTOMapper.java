package com.scores.mapper;

import com.scores.dto.InformacijaDTO;
import com.scores.model.Informacija;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class InformacijaDTOMapper implements MapperInterface<Informacija, InformacijaDTO> {

    private ModelMapper modelMapper;

    @Override
    public Informacija toEntity(InformacijaDTO dto) throws ParseException {
        return modelMapper.map(dto, Informacija.class);
    }

    @Override
    public InformacijaDTO toDto(Informacija entity) {
        return modelMapper.map(entity, InformacijaDTO.class);
    }

    @Autowired
    public InformacijaDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
