package com.dimcica.laststicker.helper.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("checklists")
data class CollectionChecklist(
    @Id val collectionName: String,
    val checklist: String
)
