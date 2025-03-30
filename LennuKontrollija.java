package com.example.demo_fl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lennud")
public class LennuKontrollija {
    @Autowired
    private LennuTeenus lennuTeenus;
    @GetMapping("/otsi")
    public List<Lend> otsiLende(@RequestParam(required = false) String sihtkoht,
                                @RequestParam(required = false) String kuupäev,
                                @RequestParam(required = false) double maksimumHind) {
        return lennuTeenus.otsiLende(sihtkoht, kuupäev, maksimumHind);
    }
}
