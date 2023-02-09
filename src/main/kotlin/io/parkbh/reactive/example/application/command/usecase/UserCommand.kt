package io.parkbh.reactive.example.application.command.usecase

import io.parkbh.reactive.example.adapter.web.dto.RegisterUserDto
import io.parkbh.reactive.example.adapter.web.dto.UpdateUserDto

interface UserCommand {
    suspend fun register(dto: RegisterUserDto)
    suspend fun update(dto: UpdateUserDto)
}