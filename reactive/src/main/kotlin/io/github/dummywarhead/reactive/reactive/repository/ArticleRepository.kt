package io.github.dummywarhead.reactive.reactive.repository

import io.github.dummywarhead.reactive.model.Article
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ArticleRepository : ReactiveMongoRepository<Article, String> {
}