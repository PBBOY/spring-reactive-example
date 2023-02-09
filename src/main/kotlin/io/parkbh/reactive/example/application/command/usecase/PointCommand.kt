package io.parkbh.reactive.example.application.command.usecase

import io.parkbh.reactive.example.adapter.web.dto.EarnPointDto
import io.parkbh.reactive.example.adapter.web.dto.UsePointDto

interface PointCommand {
    suspend fun earn(dto: EarnPointDto)
    suspend fun use(dto: UsePointDto)
}