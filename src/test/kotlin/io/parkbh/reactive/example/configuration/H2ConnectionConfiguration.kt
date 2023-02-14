package io.parkbh.reactive.example.configuration

import io.r2dbc.spi.ConnectionFactory
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile

//@TestConfiguration
//class H2ConnectionConfiguration {
//    @Bean
//    @Profile("test")
//    fun connectionFactory() : ConnectionFactory {
//        return H2ConnectionFac
//    }
//}