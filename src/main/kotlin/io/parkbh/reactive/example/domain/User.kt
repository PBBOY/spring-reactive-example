package io.parkbh.reactive.example.domain

import io.parkbh.reactive.example.domain.vo.UserInformation
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Transient
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.annotation.processing.Generated

@Table(name = "tb_users")
class User(
    val userId: String,
    val address1: String,
    val address2: String?,
    val phone1: String,
    val phone2: String?,
    val password: String
) {

    @Id
    var id: Long = 0


    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    var updatedAt: LocalDateTime? = null

    @Transient
    var point: Point? = null

    fun createPoint(point: BigDecimal) {
        this.point = Point(
                userId = this.userId,
                point = point
            )
    }

}