package com.msn.codeexam.service.mapper;

import com.msn.codeexam.model.dto.PartyDto;
import com.msn.codeexam.model.entity.Party;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PartyMapper implements Mapper<PartyDto, Party> {

    //Component used for converting entities to DTO and vice versa.

    private ModelMapper mapper;

    @Autowired
    public PartyMapper(ModelMapper modelMapper) {
        this.mapper = modelMapper;
    }

    @Override
    public Party mapToEntity(PartyDto dto) {
        return mapper.map(dto, Party.class);
    }

    @Override
    public PartyDto mapToDto(Party entity) {
        return mapper.map(entity, PartyDto.class);
    }

    @Override
    public List<Party> mapDtoListToEntityList(List<PartyDto> dtoList) {
        return dtoList.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public List<PartyDto> mapEntityListToDtoList(List<Party> entityList) {
        return entityList.stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
