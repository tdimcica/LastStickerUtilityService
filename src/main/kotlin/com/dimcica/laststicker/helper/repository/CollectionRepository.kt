package com.dimcica.laststicker.helper.repository

import com.dimcica.laststicker.helper.model.Collection
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CollectionRepository: ReactiveMongoRepository<Collection, String> {
}
