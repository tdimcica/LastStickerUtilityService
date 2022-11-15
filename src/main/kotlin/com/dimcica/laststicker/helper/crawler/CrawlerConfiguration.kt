package com.dimcica.laststicker.helper.crawler

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CrawlerConfiguration {
    @Bean
    fun collectionChecklistCrawler(): CollectionChecklistCrawler = CollectionChecklistCrawler()
}
