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
                // 적립
                PUT("/earn", routerHandler::earnPoint)
                // 사용
                PUT("/use", routerHandler::userRegister)
            }

            "/api/users".nest {
                POST("", routerHandler::userRegister)
                PUT("", routerHandler::userUpdate)
            }
        }
    }
}