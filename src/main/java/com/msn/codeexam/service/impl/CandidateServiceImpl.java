package com.msn.codeexam.service.impl;

import com.msn.codeexam.exception.DataNotFoundException;
import com.msn.codeexam.model.dto.PartyDto;
import com.msn.codeexam.model.dto.CandidateDto;
import com.msn.codeexam.model.entity.Candidate;
import com.msn.codeexam.payload.request.CandidateAddEditRequest;
import com.msn.codeexam.repository.CandidateRepository;
import com.msn.codeexam.service.interfaces.CandidateService;
import com.msn.codeexam.service.mapper.PartyMapper;
import com.msn.codeexam.service.mapper.CandidateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    private CandidateRepository repository;
    private CandidateMapper candidateMapper;
    private PartyMapper partyMapper;
    private PartyServiceImpl partyService;

    @Autowired
    public CandidateServiceImpl(CandidateRepository repository, CandidateMapper candidateMapper, PartyMapper partyMapper, PartyServiceImpl partyService) {
        this.repository = repository;
        this.candidateMapper = candidateMapper;
        this.partyMapper = partyMapper;
        this.partyService = partyService;
    }

    @Override
    public List<CandidateDto> findAll() {
        List<Candidate> candidates = repository.findAllPartyMembers().orElseThrow(() -> new DataNotFoundException("No party-members present in system!"));
        return candidateMapper.mapEntityListToDtoList(candidates);
    }

    @Override
    public CandidateDto findById(Long id) {
        Candidate candidate = repository.findById(id).orElseThrow(() -> new DataNotFoundException("No party-member with id: " + id + " present in system!"));
        return candidateMapper.mapToDto(candidate);
    }

    @Override
    public CandidateDto edit(CandidateAddEditRequest candidateAddEditRequest, Long id) {
        Candidate candidate = repository.findById(id).orElseThrow(() -> new DataNotFoundException("No party-member with id: " + id + " present in system!"));
        PartyDto partyDto = partyService.findPartyByName(candidateAddEditRequest.getPartyName());

        candidate.setFirstName(candidateAddEditRequest.getFirstName());
        candidate.setLastName(candidateAddEditRequest.getLastName());
        candidate.setParty(partyMapper.mapToEntity(partyDto));

        repository.save(candidate);

        return candidateMapper.mapToDto(candidate);
    }

    @Override
    public List<CandidateDto> findPartyMembersByParty(String partyName) {
        List<Candidate> partyMembers = repository.findAllPartyMembers().orElseThrow(() -> new DataNotFoundException("No party-members belonging to party: " + partyName + " present in system!"));
        return candidateMapper.mapEntityListToDtoList(partyMembers);
    }

    @Override
    public void delete(Long id) {
        Candidate candidate = repository.findById(id).orElseThrow(() -> new DataNotFoundException("No party-member with id: " + id + " present in system!"));
        repository.delete(candidate);
    }

    @Override
    public CandidateDto save(CandidateAddEditRequest candidateAddEditRequest) {
        PartyDto partyDto = partyService.findPartyByName(candidateAddEditRequest.getPartyName());

        Candidate candidate = new Candidate(
                candidateAddEditRequest.getFirstName(),
                candidateAddEditRequest.getLastName(),
                partyMapper.mapToEntity(partyDto)
        );

        repository.save(candidate);
        return candidateMapper.mapToDto(candidate);
    }
}
