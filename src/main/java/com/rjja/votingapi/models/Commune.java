package com.rjja.votingapi.models;

import jakarta.persistence.*;

@Entity(name = "commune")
public class Commune {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "code_cin", nullable = false)
    String code_cin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "region_id")
    private Region region;


    public Commune() {

    }

    public Commune(String name, String code_cin, Region region) {
        this.name = name;
        this.code_cin = code_cin;
        this.region = region;
    }

    public Commune(String name, String code_cin, Region region, Long id) {
        this.name = name;
        this.code_cin = code_cin;
        this.region = region;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
