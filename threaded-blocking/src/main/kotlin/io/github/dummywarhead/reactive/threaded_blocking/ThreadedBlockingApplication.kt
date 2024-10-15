package io.github.dummywarhead.reactive.threaded_blocking

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ThreadedBlockingApplication

fun main(args: Array<String>) {
	runApplication<ThreadedBlockingApplication>(*args)
}
