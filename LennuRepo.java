package com.example.demo_fl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LennuRepo extends JpaRepository<Lend, Long> {
    List<Lend> findBySihtkohtContainingIgnoreCase(String sihtkoht);
    List<Lend> findByKuupäev(String kuupäev);
    List<Lend> findByHindLessThanEqual(double hind);
}
