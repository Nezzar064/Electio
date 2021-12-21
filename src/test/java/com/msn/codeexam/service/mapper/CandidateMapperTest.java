package com.msn.codeexam.service.mapper;

import com.msn.codeexam.model.dto.PartyDto;
import com.msn.codeexam.model.entity.Party;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CandidateMapperTest {


    private final ModelMapper mapper = new ModelMapper();

    @Test
    void mapToDto() {
        Party party = new Party(1L, "Socialdemokratiet");
        PartyDto partyDto = mapper.map(party, PartyDto.class);
        assertEquals(partyDto.getId(), party.getId());
        assertEquals(partyDto.getPartyName(), party.getPartyName());
    }

    @Test
    void mapToEntity() {
        PartyDto partyDto = new PartyDto(1L, "Socialdemokratiet");
        Party party = mapper.map(partyDto, Party.class);
        assertEquals(party.getId(), partyDto.getId());
        assertEquals(party.getPartyName(), partyDto.getPartyName());
    }

    @Test
    void mapEntityListToDtoList() {
        Party party = new Party(1L, "Socialdemokratiet");
        Party party1 = new Party(2L, "Venstre");
        Party party2 = new Party(3L, "SF");

        List<Party> parties = new ArrayList<>();
        parties.add(party);
        parties.add(party1);
        parties.add(party2);

        List<PartyDto> partyDtos = parties.stream().map(this::mapToDto).collect(Collectors.toList());

        assertEquals(partyDtos.get(0).getId(), parties.get(0).getId());
        assertEquals(partyDtos.get(0).getPartyName(), parties.get(0).getPartyName());

        assertEquals(partyDtos.get(1).getId(), parties.get(1).getId());
        assertEquals(partyDtos.get(1).getPartyName(), parties.get(1).getPartyName());

        assertEquals(partyDtos.get(2).getId(), parties.get(2).getId());
        assertEquals(partyDtos.get(2).getPartyName(), parties.get(2).getPartyName());

    }

    PartyDto mapToDto(Party party) {
        return mapper.map(party, PartyDto.class);
    }
}