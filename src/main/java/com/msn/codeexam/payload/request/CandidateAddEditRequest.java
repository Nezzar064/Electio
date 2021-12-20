package com.msn.codeexam.payload.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
public class CandidateAddEditRequest {

    @NotBlank(message = "Please provide a firstname!")
    private String firstName;
    @NotBlank(message = "Please provide a lastname!")
    private String lastName;
    @NotBlank(message = "Please provide a party name!")
    private String partyName;

    public CandidateAddEditRequest(String firstName, String lastName, String partyName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.partyName = partyName;
    }
}
