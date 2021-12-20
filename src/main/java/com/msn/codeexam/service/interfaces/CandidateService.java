package com.msn.codeexam.service.interfaces;

import com.msn.codeexam.model.dto.PartyDto;
import com.msn.codeexam.model.dto.CandidateDto;
import com.msn.codeexam.payload.request.CandidateAddEditRequest;
import com.msn.codeexam.payload.response.CandidateListResponse;

import java.util.List;

public interface CandidateService extends ReadService<CandidateDto, Long> {

    CandidateDto save(CandidateAddEditRequest candidateAddEditRequest);

    CandidateDto edit(CandidateAddEditRequest candidateAddEditRequest, Long id);

    List<CandidateDto> findPartyMembersByParty(String partyName);

    List<CandidateListResponse> findCandidatesWithOnlyPartyName();

    void delete(Long id);

}
