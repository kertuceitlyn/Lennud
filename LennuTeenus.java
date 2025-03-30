package com.example.demo_fl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LennuTeenus {
    @Autowired
    private LennuRepo lennuRepo;
    public List<Lend> otsiLende(String sihtkoht, String kuupäev, Double maksimumHind) {
        if(sihtkoht != null) {
            return lennuRepo.findBySihtkohtContainingIgnoreCase(sihtkoht);
        } else if (kuupäev != null) {
            return lennuRepo.findByKuupäev(kuupäev);
        } else if (maksimumHind != null) {
            return lennuRepo.findByHindLessThanEqual(maksimumHind);
        }
        return lennuRepo.findAll();
    }
}
