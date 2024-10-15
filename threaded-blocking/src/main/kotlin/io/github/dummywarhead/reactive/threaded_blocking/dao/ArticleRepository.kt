package io.github.dummywarhead.reactive.threaded_blocking.dao

import io.github.dummywarhead.reactive.model.Article
import org.springframework.data.mongodb.repository.MongoRepository

interface ArticleRepository : MongoRepository<Article, String>