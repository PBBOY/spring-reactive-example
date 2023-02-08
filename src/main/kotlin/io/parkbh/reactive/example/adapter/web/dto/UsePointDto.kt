package io.parkbh.reactive.example.adapter.web.dto

import java.math.BigDecimal

data class UsePointDto(
    val userId: String,
    val point: BigDecimal
)