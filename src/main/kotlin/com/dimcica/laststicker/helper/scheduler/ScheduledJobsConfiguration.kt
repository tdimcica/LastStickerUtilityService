package com.dimcica.laststicker.helper.scheduler

import com.dimcica.laststicker.helper.crawler.CollectionCrawler
import com.dimcica.laststicker.helper.repository.CollectionRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ScheduledJobsConfiguration {
    @Bean
    fun scheduledCollectionCrawler(
        collectionRepository: CollectionRepository,
        collectionCrawler: CollectionCrawler
    ) = ScheduledCollectionCrawler(
        collectionRepository = collectionRepository,
        collectionCrawler = collectionCrawler
    )
}
