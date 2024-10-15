package io.github.dummywarhead.reactive.reactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveAppApplication

fun main(args: Array<String>) {
	runApplication<ReactiveAppApplication>(*args)
}
