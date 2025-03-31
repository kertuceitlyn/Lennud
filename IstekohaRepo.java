package com.example.demo_fl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IstekohaRepo extends JpaRepository<Istekoht, Long> {
    List<Istekoht> findByLendAndKashõivatudFalse(Lend lend);
}
