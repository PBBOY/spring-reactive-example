package io.parkbh.reactive.example.application.command.usecase

interface UserCommand {
    suspend fun register()
    suspend fun update()
}