package io.parkbh.reactive.example.adapter.web.exception.dto

data class ErrorResponse(
    var code: String = "ES_0001",
    val message: String
)