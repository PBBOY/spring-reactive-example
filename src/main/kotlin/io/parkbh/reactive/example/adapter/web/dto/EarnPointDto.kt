package io.parkbh.reactive.example.adapter.web.dto

import java.math.BigDecimal
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.NotEmpty

data class EarnPointDto(
    @field:NotEmpty(message = "사용자 아이디는 공백일 수 없습니다.")
    val userId: String,
    @field:DecimalMin(value = "0.0", inclusive = false, message = "포인트는 0이상 이어야 합니다.")
    val point: BigDecimal
) {
}