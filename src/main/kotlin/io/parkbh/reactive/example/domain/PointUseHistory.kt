package io.parkbh.reactive.example.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "tb_point_history")
class PointUseHistory(

) {
    @Id
    val id: Long = 0
}