package io.parkbh.reactive.example.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Table(name = "tb_point")
class Point(
    @Id
    @Column(value = "user_id")
    val userId: String,
    var point: BigDecimal
) : Persistable<String> {
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    var updatedAt: LocalDateTime? = null

    @Transient
    private var isNew: Boolean = true

    fun earn(earnPoint: BigDecimal) {
        this.isNew = false
        this.point += earnPoint

    }

    fun use(usePoint: BigDecimal) {
        this.isNew = false
        if (this.point >= usePoint) {
            this.point -= usePoint
        } else {
            throw IllegalStateException("")
        }
    }

    override fun getId(): String = this.userId

    override fun isNew(): Boolean = this.isNew
}