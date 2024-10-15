package io.github.dummywarhead.reactive.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "article")
data class Article(
    val lang : String,
    @Id
    val name : String
)