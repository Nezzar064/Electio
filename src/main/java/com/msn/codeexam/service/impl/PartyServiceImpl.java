package com.msn.codeexam.service.impl;

import com.msn.codeexam.exception.DataNotFoundException;
import com.msn.codeexam.model.dto.PartyDto;
import com.msn.codeexam.model.entity.Party;
import com.msn.codeexam.repository.PartyRepository;
import com.msn.codeexam.service.interfaces.PartyService;
import com.msn.codeexam.service.mapper.PartyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyServiceImpl implements PartyService {

    private PartyRepository repository;
    private PartyMapper mapper;

    @Autowired
    public PartyServiceImpl(PartyRepository repository, PartyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PartyDto> findAll() {
        List<Party> parties = repository.findAllParties().orElseThrow(() -> new DataNotFoundException("No parties present in system!"));
        return mapper.mapEntityListToDtoList(parties);
    }

    @Override
    public PartyDto findById(Long id) {
        Party party = repository.findById(id).orElseThrow(() -> new DataNotFoundException("No party with id: " + id + " present in system!"));
        return mapper.mapToDto(party);
    }

    @Override
    public PartyDto findPartyByName(String name) {
        Party party = repository.findPartyByPartyName(name).orElseThrow(() -> new DataNotFoundException("No party with name: " + name + " present in system!"));
        return mapper.mapToDto(party);
    }
}
