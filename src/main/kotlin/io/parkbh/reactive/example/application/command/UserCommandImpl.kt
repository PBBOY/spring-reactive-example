package io.parkbh.reactive.example.application.command

import io.parkbh.reactive.example.application.command.usecase.UserCommand
import org.springframework.stereotype.Service

@Service
class UserCommandImpl : UserCommand {

    override suspend fun register() {
        TODO("Not yet implemented")
    }

    override suspend fun update() {
        TODO("Not yet implemented")
    }
}