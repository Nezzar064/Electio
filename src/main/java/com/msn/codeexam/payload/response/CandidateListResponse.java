package com.msn.codeexam.payload.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class CandidateListResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String partyName;

    public CandidateListResponse(Long id, String firstName, String lastName, String partyName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.partyName = partyName;
    }
}
