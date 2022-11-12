package com.dimcica.laststicker.helper.repository

import com.dimcica.laststicker.helper.model.CollectionChecklist
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CollectionChecklistRepository: ReactiveMongoRepository<CollectionChecklist, String> {
}
