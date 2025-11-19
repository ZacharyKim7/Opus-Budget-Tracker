package com.opus.budget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class OpusBudgetTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpusBudgetTrackerApplication.class, args);
    }
}
