package com.rjja.votingapi.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "personne")
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    String idCin, authType, authData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cin_id", referencedColumnName = "id")
    private Cin cin;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bv_id", referencedColumnName = "id")
    private Bv bv;

}
