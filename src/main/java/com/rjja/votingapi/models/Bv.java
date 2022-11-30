package com.rjja.votingapi.models;

import jakarta.persistence.*;

@Entity(name = "bv")
public class Bv {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "code_cin", nullable = false)
    String code_cin;

    @Transient
    private Commune commune;

    public Bv() {

    }

    public Bv(String name, String code_cin, Commune commune) {
        this.name = name;
        this.code_cin = code_cin;
        this.commune = commune;
    }

    public Bv(Long id, String name, String code_cin, Commune commune) {
        this.id = id;
        this.name = name;
        this.code_cin = code_cin;
        this.commune = commune;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode_cin() {
        return code_cin;
    }

    public void setCode_cin(String code_cin) {
        this.code_cin = code_cin;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }
}
