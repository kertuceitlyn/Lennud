package com.example.demo_fl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IstekohaRepo extends JpaRepository<Istekoht, Long> {
    List<Istekoht> findByLendAndKasHõivatudFalse(Lend lend);
}
