package io.parkbh.reactive.example.adapter.web

import io.parkbh.reactive.example.application.command.usecase.PointCommand
import io.parkbh.reactive.example.application.command.usecase.UserCommand
import org.springframework.stereotype.Component
import org.springframework.validation.Validator
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class RouterHandler(
    private val validator: Validator,
    private val pointCommand: PointCommand,
    private val userCommand: UserCommand
) {

    suspend fun userRegister(request: ServerRequest) = request.awaitBody<Any>().let {
        ServerResponse
            .ok()
            .bodyValueAndAwait("")
    }

    suspend fun userUpdate(request: ServerRequest) = request.awaitBody<Any>().let {
        ServerResponse
            .ok()
            .bodyValueAndAwait("")
    }

    suspend fun earnPoint(request: ServerRequest) = request.awaitBody<Any>().let {
        ServerResponse.ok()
            .bodyValueAndAwait("")
    }

    suspend fun usePoint(request: ServerRequest) = request.awaitBody<Any>().let {
        ServerResponse.ok()
            .bodyValueAndAwait("")
    }
}
