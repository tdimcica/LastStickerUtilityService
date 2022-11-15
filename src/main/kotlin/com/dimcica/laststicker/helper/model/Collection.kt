package com.dimcica.laststicker.helper.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("collections")
data class Collection(
    @Id val url: String,
    val name: String? = null,
    val checklist: Map<String, CardDetail>? = null
)

data class CardDetail(
    val title: String,
    val section: String,
    val type: String,
    val need: Int,
    val offer: Int
)
