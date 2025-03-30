package com.example.demo_fl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/istekohad")
public class IstekohaKontrollija {
    @Autowired
    private IstekohaTeenus istekohaTeenus;
    @Autowired
    private IstekohaRepo istekohaRepo;

    @GetMapping("/soovita")
    public List<Istekoht> otsiIstekohti(@RequestParam Long lendId,
                                           @RequestParam(required = false, defaultValue = "false") boolean aknaÄäres,
                                           @RequestParam(required = false, defaultValue = "false") boolean rohkemJalaruumi,
                                           @RequestParam(required = false, defaultValue = "false") boolean väljapääsuLähedal) {
        Optional<Istekoht> lend = istekohaRepo.findById(lendId);
        return lend.map(value -> istekohaTeenus.soovitaIstekohti(value.getLend(), aknaÄäres, rohkemJalaruumi, väljapääsuLähedal)).orElse(List.of());
    }
}
