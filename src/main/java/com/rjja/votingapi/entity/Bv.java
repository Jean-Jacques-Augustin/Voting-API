package com.rjja.votingapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "burreau_de_vote")
@NoArgsConstructor
@Getter
@Setter
public class Bv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
}
