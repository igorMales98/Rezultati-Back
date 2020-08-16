package com.scores.mapper;

import com.scores.dto.FudbalskiKlubDTO;
import com.scores.model.FudblaskiKlub;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class FudbalskiKlubDTOMapper implements MapperInterface<FudblaskiKlub, FudbalskiKlubDTO> {

    private ModelMapper modelMapper;

    @Override
    public FudblaskiKlub toEntity(FudbalskiKlubDTO dto) throws ParseException {
        return modelMapper.map(dto, FudblaskiKlub.class);
    }

    @Override
    public FudbalskiKlubDTO toDto(FudblaskiKlub entity) {
        return modelMapper.map(entity, FudbalskiKlubDTO.class);
    }

    @Autowired
    public FudbalskiKlubDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
