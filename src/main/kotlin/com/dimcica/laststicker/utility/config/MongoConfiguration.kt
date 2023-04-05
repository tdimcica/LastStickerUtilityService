package com.dimcica.laststicker.utility.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableReactiveMongoRepositories(
    basePackages = ["com.dimcica.laststicker.helper.repository"]
)
class MongoConfiguration
