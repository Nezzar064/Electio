package com.msn.codeexam.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "parties")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Party implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "party_seq_gen")
    @SequenceGenerator(name = "party_seq_gen", sequenceName = "party_seq_gen", allocationSize = 1, initialValue = 7)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String partyName;

    @Column(name = "symbol")
    private String partySymbol;

    @OneToMany(mappedBy = "party", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Candidate> candidates;

    //For Unit Test
    public Party(Long id, String partyName) {
        this.id = id;
        this.partyName = partyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party = (Party) o;
        return Objects.equals(id, party.id) && Objects.equals(partyName, party.partyName) && Objects.equals(partySymbol, party.partySymbol) && Objects.equals(candidates, party.candidates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partyName, partySymbol, candidates);
    }
}
