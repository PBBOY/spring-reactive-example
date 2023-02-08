package io.parkbh.reactive.example.application.command.usecase

interface PointCommand {
    suspend fun earn()
    suspend fun use()
}