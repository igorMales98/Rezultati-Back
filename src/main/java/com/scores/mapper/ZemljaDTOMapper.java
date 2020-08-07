package com.scores.mapper;

import com.scores.dto.ZemljaDTO;
import com.scores.model.Zemlja;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class ZemljaDTOMapper implements MapperInterface<Zemlja, ZemljaDTO> {

    private ModelMapper modelMapper;

    @Override
    public Zemlja toEntity(ZemljaDTO dto) throws ParseException {
        return modelMapper.map(dto, Zemlja.class);
    }

    @Override
    public ZemljaDTO toDto(Zemlja entity) {
        return modelMapper.map(entity, ZemljaDTO.class);
    }

    @Autowired
    public ZemljaDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
