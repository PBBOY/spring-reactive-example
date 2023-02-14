package io.parkbh.reactive.example.adapter.infrastructure.r2dbc

import io.parkbh.reactive.example.domain.Point
import io.parkbh.reactive.example.domain.User
import io.parkbh.reactive.example.domain.repository.UserRepository
import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.data.repository.query.Param
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.math.BigDecimal
import java.time.LocalDateTime

interface ReactiveUserRepository : ReactiveCrudRepository<User, Long> {
    suspend fun existsByUserId(@Param("userId") id: String): Mono<Boolean>
    suspend fun findByUserId(@Param("userId") id: String): Mono<User>?
}

@Repository
class R2dbcUserRepository(
    private val reactiveRepository: ReactiveUserRepository,
    private val databaseClient: DatabaseClient
    ) : UserRepository {
    override suspend fun exists(id: String): Boolean {
        return reactiveRepository.existsByUserId(id).awaitSingle()
    }

    override suspend fun findById(id: String): User? {
        val sql = """
            SELECT 
                u.id as id,
                u.user_id as u_user_id,
                u.address1,
                u.address2,
                u.phone1,
                u.phone2,
                u.password,
                u.created_at as u_created_at,
                u.updated_at as u_updated_at,
                p.user_id as p_user_id,
                p.point,
                p.created_at as p_created_at,
                p.updated_at as p_updated_at
            FROM tb_users u
            LEFT JOIN tb_point p on u.user_id = p.user_id
            WHERE u.user_id = :id
        """.trimIndent()

        return databaseClient.sql(sql)
            .bind("id", id)
            .fetch().all()
            .bufferUntilChanged { it["user_id"] }
            .map { rows ->
                val row = rows.first()
                User(
                    userId = row["u_user_id"] as String,
                    address1 = row["address1"] as String,
                    address2 = row["address2"] as String,
                    phone1 = row["phone1"] as String,
                    phone2 = row["phone2"] as String,
                    password = row["password"] as String,
                ).apply {
                    this.createdAt = row["u_created_at"] as LocalDateTime
                    this.updatedAt = row["u_updated_at"] as? LocalDateTime?
                    if (row["p_user_id"] != null) {
                        this.point = Point(
                            userId = row["p_user_id"] as String,
                            point = row["point"] as BigDecimal
                        ).also { p ->
                            p.createdAt = row["p_created_at"] as LocalDateTime
                            p.updatedAt = row["p_updated_at"] as? LocalDateTime?
                        }
                    } else {
                        return@apply
                    }
                }
            }.awaitFirstOrNull()
    }

    override suspend fun create(user: User): User {
        return reactiveRepository.save(user).awaitSingle()
    }

    override suspend fun update(user: User) {
        reactiveRepository.save(user)
    }
}