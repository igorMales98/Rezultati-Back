package com.scores.mapper;

import com.scores.dto.FudbalskiRezultatDTO;
import com.scores.model.FudbalskiRezultat;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class FudbalskiRezultatDTOMapper implements MapperInterface<FudbalskiRezultat, FudbalskiRezultatDTO> {

    private ModelMapper modelMapper;

    @Override
    public FudbalskiRezultat toEntity(FudbalskiRezultatDTO dto) throws ParseException {
        return modelMapper.map(dto, FudbalskiRezultat.class);
    }

    @Override
    public FudbalskiRezultatDTO toDto(FudbalskiRezultat entity) {
        return modelMapper.map(entity, FudbalskiRezultatDTO.class);
    }

    @Autowired
    public FudbalskiRezultatDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
