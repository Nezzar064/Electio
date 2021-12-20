package com.msn.codeexam.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "candidates")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_seq_gen")
    @SequenceGenerator(name = "candidate_seq_gen", sequenceName = "candidate_seq_gen", allocationSize = 1, initialValue = 34)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "party")
    @ToString.Exclude
    private Party party;

    public Candidate(String firstName, String lastName, Party party) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.party = party;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate that = (Candidate) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(party, that.party);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, party);
    }
}
