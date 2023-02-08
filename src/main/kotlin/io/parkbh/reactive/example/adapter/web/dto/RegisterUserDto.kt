package io.parkbh.reactive.example.adapter.web.dto

data class RegisterUserDto(
    val userId: String,
    val userName: String,
    val address1: String,
    val address2: String?,
    val phone1: String,
    val phone2: String?,
    val password: String
)