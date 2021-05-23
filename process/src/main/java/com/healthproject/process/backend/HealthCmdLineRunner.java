package com.healthproject.process.backend;

import com.healthproject.process.repository.HealthRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.Duration;


public class HealthCmdLineRunner {
    private static final Logger log = LoggerFactory.getLogger(HealthCmdLineRunner.class);

    @Bean
    public CommandLineRunner getHealthRecords(HealthRepository healthRepo){

        return args -> {
            healthRepo.findAll().doOnNext(health -> {
                log.info(health.toString());
            }).blockLast(Duration.ofSeconds(10));
        };
    }



}
