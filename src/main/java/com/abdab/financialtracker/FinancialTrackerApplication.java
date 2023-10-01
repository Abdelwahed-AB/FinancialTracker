package com.abdab.financialtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FinancialTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancialTrackerApplication.class, args);
    }

}
