package com.dimcica.mylaststickerhelper.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories


@Configuration
@EnableReactiveMongoRepositories(
    basePackages = ["com.dimcica.mylaststickerhelper.repository"]
)
class MongoConfiguration () {}
