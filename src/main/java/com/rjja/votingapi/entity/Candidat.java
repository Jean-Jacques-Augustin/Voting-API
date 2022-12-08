package com.rjja.votingapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "candidat")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String partie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Cin cin;
}
