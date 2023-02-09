package io.parkbh.reactive.example.application.command

import io.parkbh.reactive.example.adapter.web.dto.RegisterUserDto
import io.parkbh.reactive.example.adapter.web.dto.UpdateUserDto
import io.parkbh.reactive.example.application.command.usecase.UserCommand
import org.springframework.stereotype.Service

@Service
class UserCommandImpl : UserCommand {

    override suspend fun register(dto: RegisterUserDto) {
        TODO("Not yet implemented")
    }

    override suspend fun update(dto: UpdateUserDto) {
        TODO("Not yet implemented")
    }

}