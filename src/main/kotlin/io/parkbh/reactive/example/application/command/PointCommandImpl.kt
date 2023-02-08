package io.parkbh.reactive.example.application.command

import io.parkbh.reactive.example.application.command.usecase.PointCommand
import org.springframework.stereotype.Service

@Service
class PointCommandImpl : PointCommand {
    override suspend fun earn() {
        TODO("Not yet implemented")
    }

    override suspend fun use() {
        TODO("Not yet implemented")
    }
}