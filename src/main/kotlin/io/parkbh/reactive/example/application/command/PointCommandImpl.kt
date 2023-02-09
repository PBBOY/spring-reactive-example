package io.parkbh.reactive.example.application.command

import io.parkbh.reactive.example.adapter.web.dto.EarnPointDto
import io.parkbh.reactive.example.adapter.web.dto.UsePointDto
import io.parkbh.reactive.example.application.command.usecase.PointCommand
import org.springframework.stereotype.Service

@Service
class PointCommandImpl : PointCommand {
    override suspend fun earn(dto: EarnPointDto) {
        TODO("Not yet implemented")
    }

    override suspend fun use(dto: UsePointDto) {
        TODO("Not yet implemented")
    }

}