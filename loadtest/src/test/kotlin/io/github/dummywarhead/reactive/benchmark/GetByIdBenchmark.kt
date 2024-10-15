package io.github.dummywarhead.reactive.benchmark

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http
import io.gatling.javaapi.http.HttpDsl.status
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds
import kotlin.time.toJavaDuration


class GetByIdBenchmark : Simulation() {

    private val httpProtocol = http.baseUrl("http://localhost:8080/")
        .acceptHeader("application/json")

    private val scenario = scenario("get by id")
        .repeat(10).on(
            exec (
                http("").get("/api/articles/Main_Page")
                    .check(status().`is`(200))
            ).pause(1.seconds.toJavaDuration())
        ).pace(1.seconds.toJavaDuration())

    init {
        setUp(
            scenario.injectOpen(
                rampUsersPerSec(10.0).to(500.0).during(20.minutes.toJavaDuration())
            )
        ).protocols(httpProtocol)
    }

}