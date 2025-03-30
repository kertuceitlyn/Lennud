package com.example.demo_fl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IstekohaTeenus {
    @Autowired
    private IstekohaRepo istekohaRepo;
    public List<Istekoht> soovitaIstekohti(Lend lend, boolean aknaÄäres, boolean väljapääsuLähedal, boolean rohkemJalaruumi) {
        List<Istekoht> vabadKohad = istekohaRepo.findByLendAndKasHõivatudFalse(lend);
        return vabadKohad.stream()
                .filter(istekoht -> (!aknaÄäres || istekoht.isOnAknakoht()))
                .filter(istekoht -> (!rohkemJalaruumi || istekoht.isOnRohkemJalaruumi()))
                .filter(istekoht -> (!väljapääsuLähedal || istekoht.isOnVäljapääsuLähedal()))
                .collect(Collectors.toList());
    }
}
