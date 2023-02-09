package io.parkbh.reactive.example.adapter.web.dto

import java.math.BigDecimal
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.NotEmpty

data class UsePointDto(
    @field:NotEmpty(message = "사용자 아이디는 공백일 수 없습니다.")
    val userId: String,
    @field:DecimalMin(value = "1000.00", inclusive = false, message = "포인트는 1000포인트 이상부터 사용 가능합니다.")
    val point: BigDecimal
)