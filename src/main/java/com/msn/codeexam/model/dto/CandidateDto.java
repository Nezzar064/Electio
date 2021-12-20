package com.msn.codeexam.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class CandidateDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    @JsonIgnore
    private PartyDto partyDto;

    public CandidateDto(Long id, String firstName, String lastName, PartyDto partyDto) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.partyDto = partyDto;
    }
}
