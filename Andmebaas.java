package com.example.demo_fl;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
@Configuration
public class Andmebaas {
    @Bean
    public DataSource andmebaas() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/lend_db")
                .username("root")
                .password("salasõna")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
