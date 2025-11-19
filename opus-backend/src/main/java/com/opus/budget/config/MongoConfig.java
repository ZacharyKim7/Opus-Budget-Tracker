package com.opus.budget.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
public class MongoConfig {
    // MongoDB configuration class
    // EnableMongoAuditing allows automatic population of @CreatedDate and @LastModifiedDate fields
}
