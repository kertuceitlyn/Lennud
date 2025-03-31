package com.example.demo_fl;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Lend {
    @Id
    @GeneratedValue
    private Long id;
    private String sihtkoht;
    private String kuupäev;
    private String lennuaeg;
    private double hind;
    @OneToMany(mappedBy = "lend", cascade = CascadeType.ALL)
    private List<Istekoht> istekohad;
    public Lend(Long id, String sihtkoht, String kuupäev, String lennuaeg, double hind, List<Istekoht> istekohad) {
        this.id = id;
        this.sihtkoht = sihtkoht;
        this.kuupäev = kuupäev;
        this.lennuaeg = lennuaeg;
        this.hind = hind;
        this.istekohad = (istekohad != null) ? new ArrayList<>(istekohad) : new ArrayList<>();
    }
}
