package com.msn.codeexam.service.interfaces;

import com.msn.codeexam.model.dto.PartyDto;

public interface PartyService extends ReadService<PartyDto, Long> {

    PartyDto findPartyByName(String name);
}
