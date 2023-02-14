package io.parkbh.reactive.example.domain.repository

import io.parkbh.reactive.example.domain.User

interface UserRepository {
    suspend fun exists(id: String): Boolean
    /**
     * 사용자 조회
     * @param id 사용자 아이디
     */
    suspend fun findById(id: String): User?

    /**
     * 사용자 생성
     * @param user 사용자 Entity
     */
    suspend fun create(user: User) : User

    /**
     * 사용자 상태 변경
     * @param user 사용자 Entity
     */
    suspend fun update(user: User)
}