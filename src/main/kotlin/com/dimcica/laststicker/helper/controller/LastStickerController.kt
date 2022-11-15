package com.dimcica.laststicker.helper.controller

import com.dimcica.laststicker.helper.crawler.CollectionCrawler
import com.dimcica.laststicker.helper.model.Collection
import com.dimcica.laststicker.helper.repository.CollectionRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/laststicker")
class LastStickerController(
    val collectionCrawler: CollectionCrawler,
    val collectionRepository: CollectionRepository
) {
    @GetMapping(
        value = ["/collection"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getCollections(): Flux<Collection> {
        return collectionRepository.findAll()
    }

    @PutMapping(
        value = ["/collection"],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun addCollection(
        @RequestBody collection: Collection
    ) {
        collectionRepository.save(collection).subscribe()
    }

    @DeleteMapping(
        value = ["/collection"],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun deleteCollection(@RequestBody collection: Collection) {
        collectionRepository.delete(collection).subscribe()
    }

    @PutMapping(
        value = ["/collection/scrape"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    suspend fun scrapeCollection(
        @RequestBody collection: Collection
    ): Collection {
        return collectionCrawler.scrape(collection)
    }
}
