package io.parkbh.reactive.example.adapter.web

import io.parkbh.reactive.example.adapter.web.dto.EarnPointDto
import io.parkbh.reactive.example.adapter.web.dto.RegisterUserDto
import io.parkbh.reactive.example.adapter.web.dto.UpdateUserDto
import io.parkbh.reactive.example.adapter.web.dto.UsePointDto
import io.parkbh.reactive.example.application.command.usecase.PointCommand
import io.parkbh.reactive.example.application.command.usecase.UserCommand
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.validation.BeanPropertyBindingResult
import org.springframework.validation.Validator
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.server.ResponseStatusException

@Component
class RouterHandler(
    private val validator: Validator,
    private val pointCommand: PointCommand,
    private val userCommand: UserCommand
) {

    suspend fun userRegister(request: ServerRequest) = request.awaitBody<RegisterUserDto>().let {
        this.validate(it)
        ServerResponse
            .ok()
            .bodyValueAndAwait(userCommand.register(it))
    }

    suspend fun userUpdate(request: ServerRequest) = request.awaitBody<UpdateUserDto>().let {
        this.validate(it)
        ServerResponse
            .ok()
            .bodyValueAndAwait(userCommand.update(it))
    }

    suspend fun earnPoint(request: ServerRequest) = request.awaitBody<EarnPointDto>().let {
        this.validate(it)
        ServerResponse.ok()
            .bodyValueAndAwait(pointCommand.earn(it))
    }

    suspend fun usePoint(request: ServerRequest) = request.awaitBody<UsePointDto>().let {
        this.validate(it)
        ServerResponse.ok()
            .bodyValueAndAwait(pointCommand.use(it))
    }

    private fun validate(dto: Any) {
        val errors = BeanPropertyBindingResult(dto, Any::class.java.name)
        validator.validate(dto, errors)
        if (errors.hasErrors()) {
            val message = errors.fieldErrors.map { it.defaultMessage }.joinToString(" ")
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, message)
        }
    }
}
