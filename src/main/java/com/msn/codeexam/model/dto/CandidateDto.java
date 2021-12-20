package com.msn.codeexam.model.dto;

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
    @NotBlank(message = "Please provide a first name!")
    private String firstName;
    @NotBlank(message = "Please provide a last name!")
    private String lastName;
    @NotNull(message = "Please provide a valid party!")
    private PartyDto partyDto;

    public CandidateDto(Long id, String firstName, String lastName, PartyDto partyDto) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.partyDto = partyDto;
    }
}
