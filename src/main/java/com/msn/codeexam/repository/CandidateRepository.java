package com.msn.codeexam.repository;

import com.msn.codeexam.model.entity.Candidate;
import com.msn.codeexam.payload.response.CandidateListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Query("SELECT c FROM Candidate c")
    Optional<List<Candidate>> findAllPartyMembers();

    //Query used for getting party members associated with a specific party, by party name
    @Query("SELECT c FROM Candidate c WHERE c.party.partyName = :partyName")
    Optional<List<Candidate>> findCandidatesByParty(@Param("partyName") String partyName);

    //DTO Projection used for getting only id, name and party name for table display in frontend
    @Query("SELECT new com.msn.codeexam.payload.response.CandidateListResponse(c.id, c.firstName, c.lastName, c.party.partyName) FROM Candidate c")
    Optional<List<CandidateListResponse>> findCandidatesWithOnlyPartyName();
}
