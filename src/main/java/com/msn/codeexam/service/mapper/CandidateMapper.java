package com.msn.codeexam.service.mapper;

import com.msn.codeexam.model.dto.CandidateDto;
import com.msn.codeexam.model.entity.Candidate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CandidateMapper implements Mapper<CandidateDto, Candidate> {

    //Component used for converting entities to DTO and vice versa.

    private ModelMapper mapper;

    @Autowired
    public CandidateMapper(ModelMapper modelMapper) {
        this.mapper = modelMapper;
    }

    @Override
    public Candidate mapToEntity(CandidateDto dto) {
        return mapper.map(dto, Candidate.class);
    }

    @Override
    public CandidateDto mapToDto(Candidate entity) {
        return mapper.map(entity, CandidateDto.class);
    }

    @Override
    public List<Candidate> mapDtoListToEntityList(List<CandidateDto> dtoList) {
        return dtoList.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public List<CandidateDto> mapEntityListToDtoList(List<Candidate> entityList) {
        return entityList.stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
