package com.healthy.healthcheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories("com.healthy.healthcheck.repository")
@EntityScan("com.healthy.healthcheck.backend")
@EnableTransactionManagement
public class HealthcheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthcheckApplication.class, args);
    }

//    @Profile("!prod")
//    @Bean
//    public ApplicationRunner healthRecords(HealthRepository healthRepo){
//    return (args) -> {
//            healthRepo.save(new Health("Patient 1", "Good"));
//            healthRepo.save(new Health("Patient 2", "Bad"));
//            healthRepo.save(new Health("test", "Very good"));
//
//        };
//
//    }

}
