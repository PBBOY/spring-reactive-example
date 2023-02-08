package io.parkbh.reactive.example.domain

import io.parkbh.reactive.example.domain.vo.UserInformation
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Transient
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table(name = "tb_user")
class User(
    val id: Long,
    val userId: String,
    userInformation: UserInformation
) {

    var userInformation: UserInformation = userInformation
        private set

    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    var updatedAt: LocalDateTime? = null

    @Transient
    var point: Point? = null

}