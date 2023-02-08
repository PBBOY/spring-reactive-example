package io.parkbh.reactive.example.adapter.web.router

import io.parkbh.reactive.example.adapter.web.RouterHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class ReactiveRouter(private val routerHandler: RouterHandler) {

    @Bean
    fun router() = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            "/api/point".nest {
                PUT("/earn")
                PUT("/use")
            }

            "/api/users".nest {
                POST("")
                PUT("")
            }
        }
    }
}