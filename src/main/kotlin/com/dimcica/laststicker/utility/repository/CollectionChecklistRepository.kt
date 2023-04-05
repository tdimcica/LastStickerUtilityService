package com.dimcica.laststicker.utility.repository

import com.dimcica.laststicker.utility.model.CollectionChecklist
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CollectionChecklistRepository: ReactiveMongoRepository<CollectionChecklist, String>
