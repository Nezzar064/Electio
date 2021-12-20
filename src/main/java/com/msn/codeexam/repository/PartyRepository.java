package com.msn.codeexam.repository;

import com.msn.codeexam.model.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

    @Query("SELECT p FROM Party p")
    Optional<List<Party>> findAllParties();

    @Query("SELECT p FROM Party p WHERE p.partyName = :partyName")
    Optional<Party> findPartyByPartyName(@Param("partyName") String partyName);
}
