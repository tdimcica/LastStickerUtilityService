package com.dimcica.mylaststickerhelper.repository

import com.dimcica.mylaststickerhelper.model.CollectionChecklist
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CollectionChecklistRepository: ReactiveMongoRepository<CollectionChecklist, String> {
}
