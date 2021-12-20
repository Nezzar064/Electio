package com.msn.codeexam.service.interfaces;

import com.msn.codeexam.model.dto.PartyDto;

import java.util.List;

public interface PartyService extends ReadService<PartyDto, Long> {

    PartyDto findPartyByName(String name);

    List<PartyDto> getPartiesOnlyWithName();
}
