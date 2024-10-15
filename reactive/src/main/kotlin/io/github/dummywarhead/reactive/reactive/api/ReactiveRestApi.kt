package io.github.dummywarhead.reactive.reactive.api

import io.github.dummywarhead.reactive.reactive.repository.ArticleRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ReactiveRestApi(private val repository: ArticleRepository) {

    @GetMapping("/api/articles/", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun listAll() = repository.findAll()

    @GetMapping("/api/articles/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getById(@PathVariable("id") id: String) = repository.findById(id)

}