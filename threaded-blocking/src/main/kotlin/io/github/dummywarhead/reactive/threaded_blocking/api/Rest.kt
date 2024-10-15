package io.github.dummywarhead.reactive.threaded_blocking.api

import io.github.dummywarhead.reactive.model.Article
import io.github.dummywarhead.reactive.threaded_blocking.dao.ArticleRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.lang.IllegalArgumentException

@RestController()
class Rest(private val repository: ArticleRepository) {
    @GetMapping("/api/articles/", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun listAll(): List<Article> =
        repository.findAll()

    @GetMapping("/api/articles/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getById(@PathVariable("id") id: String): Article =
        repository.findById(id).orElseThrow { IllegalArgumentException("not found") }

}