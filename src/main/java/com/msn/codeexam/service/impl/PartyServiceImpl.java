package com.msn.codeexam.service.impl;

import com.msn.codeexam.exception.DataNotFoundException;
import com.msn.codeexam.model.dto.CandidateDto;
import com.msn.codeexam.model.dto.PartyDto;
import com.msn.codeexam.model.entity.Party;
import com.msn.codeexam.repository.PartyRepository;
import com.msn.codeexam.service.interfaces.PartyService;
import com.msn.codeexam.service.mapper.CandidateMapper;
import com.msn.codeexam.service.mapper.PartyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartyServiceImpl implements PartyService {

    private PartyRepository repository;
    private PartyMapper mapper;
    private CandidateMapper candidateMapper;

    @Autowired
    public PartyServiceImpl(PartyRepository repository, PartyMapper mapper, CandidateMapper candidateMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.candidateMapper = candidateMapper;
    }

    @Override
    public List<PartyDto> findAll() {
        List<Party> parties = repository.findAllParties().orElseThrow(() -> new DataNotFoundException("No parties present in system!"));
        List<PartyDto> convertedParties = mapper.mapEntityListToDtoList(parties);
        for (int i = 0; i < parties.size(); i++) {
            for (int x = 0; x < convertedParties.size(); x++) {
                convertedParties.get(x).setCandidates(
                        candidateMapper.mapEntityListToDtoList(parties.get(i).getCandidates())
                );
            }
        }
        return mapper.mapEntityListToDtoList(parties);
    }

    @Override
    public PartyDto findById(Long id) {
        Party party = repository.findById(id).orElseThrow(() -> new DataNotFoundException("No party with id: " + id + " present in system!"));
        PartyDto convertedParty = mapper.mapToDto(party);
        convertedParty.setCandidates(candidateMapper.mapEntityListToDtoList(party.getCandidates()));
        return convertedParty;
    }

    @Override
    public PartyDto findPartyByName(String name) {
        Party party = repository.findPartyByPartyName(name).orElseThrow(() -> new DataNotFoundException("No party with name: " + name + " present in system!"));
        PartyDto convertedParty = mapper.mapToDto(party);
        convertedParty.setCandidates(candidateMapper.mapEntityListToDtoList(party.getCandidates()));
        return convertedParty;
    }

    @Override
    public List<PartyDto> getPartiesOnlyWithName() {
        return repository.getPartyOnlyWithName().orElseThrow(() -> new DataNotFoundException("No parties present in system!"));
    }
}
