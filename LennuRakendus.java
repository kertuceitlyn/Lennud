package com.example.demo_fl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
class DemoFlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoFlApplication.class, args);
    }
    @Bean
    CommandLineRunner andmebaasiSeadistus(LennuRepo lennuRepo, IstekohaRepo istekohaRepo) {
        return args -> {
            Lend lend1 = new Lend(null, "Helsingi", "2025-04-10", "15:30", 80.0, List.of());
            Lend lend2 = new Lend(null, "Barcelona", "2025-04-11", "06:45", 245.0, List.of());
            lend1 = lennuRepo.save(lend1);
            lend2 = lennuRepo.save(lend2);
            List<Istekoht> istekohad = Arrays.asList(
                    new Istekoht(null, "1A", false, true, false, true, lend1),
                    new Istekoht(null, "1B", false, false, true, false, lend1),
                    new Istekoht(null, "2A", true, true, false, false, lend1),
                    new Istekoht(null, "2B", false, false, false, false, lend1),
                    new Istekoht(null, "1A", false, true, false, true, lend2),
                    new Istekoht(null, "1B", true, false, true, false, lend2),
                    new Istekoht(null, "2A", false, true, false, false, lend2),
                    new Istekoht(null, "2B", false, false, false, false, lend2)

            );
            istekohaRepo.saveAll(istekohad);
        };
    }

}
