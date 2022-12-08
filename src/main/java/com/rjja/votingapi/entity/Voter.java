package com.rjja.votingapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "voter")
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate date_vote;

    @ManyToOne()
    @JoinColumn(name = "candidat_id" , nullable = false)
    private Candidat candidat;

}
