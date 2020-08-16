package com.scores.mapper;

import com.scores.dto.TrenerDTO;
import com.scores.model.Trener;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class TrenerDTOMapper implements MapperInterface<Trener, TrenerDTO> {

    private ModelMapper modelMapper;

    @Override
    public Trener toEntity(TrenerDTO dto) throws ParseException {
        return modelMapper.map(dto, Trener.class);
    }

    @Override
    public TrenerDTO toDto(Trener entity) {
        return modelMapper.map(entity, TrenerDTO.class);
    }

    @Autowired
    public TrenerDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
