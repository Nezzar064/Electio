package com.msn.codeexam.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@RequiredArgsConstructor
public class PartyDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String partyName;
    private String partySymbol;
    private List<CandidateDto> partyMembers;

    public PartyDto(Long id, String partyName, String partySymbol, List<CandidateDto> partyMembers) {
        this.id = id;
        this.partyName = partyName;
        this.partySymbol = partySymbol;
        this.partyMembers = partyMembers;
    }
}
