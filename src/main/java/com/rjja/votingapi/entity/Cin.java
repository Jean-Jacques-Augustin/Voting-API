package com.rjja.votingapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "cin")
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class Cin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;


    String nom, prenom, sexe, lieu_naissance, adresse, profession, pere, mere, photo, lieu_delivrance;

    Long num_cin;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date_naissance, date_delivrance;
}
