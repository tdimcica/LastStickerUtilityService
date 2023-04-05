package com.dimcica.laststicker.utility.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("checklists")
data class CollectionChecklist(
    @Id val collectionName: String,
    val collectionLink: String,
    val checklist: Map<String, CardDetail>
)

data class CardDetail(
    val title: String,
    val section: String,
    val type: String,
    val need: Int,
    val offer: Int
)
