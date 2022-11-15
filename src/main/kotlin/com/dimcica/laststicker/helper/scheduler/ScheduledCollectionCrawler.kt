package com.dimcica.laststicker.helper.scheduler

import com.dimcica.laststicker.helper.crawler.CollectionCrawler
import com.dimcica.laststicker.helper.repository.CollectionRepository
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.runBlocking
import org.springframework.scheduling.annotation.Scheduled

class ScheduledCollectionCrawler(
    val collectionRepository: CollectionRepository,
    val collectionCrawler: CollectionCrawler
) {
    @Scheduled(fixedDelay = 120_000)
    fun newCollectionsScraper() {
        runBlocking {
            val collections = collectionRepository.findByNullName()
                .collectList()
                .awaitSingle()

            collections.map { collectionCrawler.scrape(it) }
                .map { collectionRepository.save(it).subscribe() }
        }
    }
}
