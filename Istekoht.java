package com.example.demo_fl;

import jakarta.persistence.*;
@Entity
public class Istekoht {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String istekohaNumber;
    private boolean kashõivatud;
    private boolean onAknakoht;
    private boolean onRohkemJalaruumi;
    private boolean onVäljapääsuLähedal;
    @ManyToOne
    @JoinColumn(name = "lend_id")
    private Lend lend;
    public Istekoht(Long id, String istekohaNumber, boolean kashõivatud, boolean onAknakoht, boolean onVäljapääsuLähedal, boolean onRohkemJalaruumi, Lend lend) {
        this.id = id;
        this.istekohaNumber = istekohaNumber;
        this.kashõivatud = kashõivatud;
        this.onAknakoht = onAknakoht;
        this.onVäljapääsuLähedal = onVäljapääsuLähedal;
        this.onRohkemJalaruumi = onRohkemJalaruumi;
        this.lend = lend;
    }

    public boolean isOnAknakoht() {
        return onAknakoht;
    }

    public boolean isOnRohkemJalaruumi() {
        return onRohkemJalaruumi;
    }

    public boolean isOnVäljapääsuLähedal() {
        return onVäljapääsuLähedal;
    }
    public Lend getLend() {
        return lend;
    }
}
