package io.parkbh.reactive.example.adapter.web.dto

import javax.validation.constraints.NotEmpty

data class RegisterUserDto(
    @field:NotEmpty(message = "아이디는 공백일 수 없습니다.")
    val userId: String,
    @field:NotEmpty(message = "이름은 공백일 수 없습니다.")
    val userName: String,
    @field:NotEmpty(message = "주소는 공백일 수 없습니다.")
    val address1: String,
    val address2: String?,
    @field:NotEmpty(message = "전화번호는 공백일 수 없습니다.")
    val phone1: String,
    val phone2: String?,
    @field:NotEmpty(message = "비밀번호는 공백일 수 없습니다.")
    val password: String
)