package com.dimcica.laststicker.helper.repository

import com.dimcica.laststicker.helper.model.Collection
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface CollectionRepository: ReactiveMongoRepository<Collection, String> {
    @Query("{ 'name' : null }")
    suspend fun findByNullName(): Flux<Collection>
}
