package com.healthy.backend;

import com.healthy.repository.HealthRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class HealthCmdLineRunner {

    @Bean
    public CommandLineRunner getHealthRecords(HealthRepository healthRepo){

        return args -> {
            healthRepo.save(new Health("Patient 1", "Good"));
            healthRepo.save(new Health("Patient 2", "Bad"));
        };



    }



}
