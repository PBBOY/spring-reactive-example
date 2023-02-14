package io.parkbh.reactive.example.unit.repository

import io.kotest.inspectors.runTest
import io.parkbh.reactive.example.adapter.infrastructure.r2dbc.R2dbcUserRepository
import io.parkbh.reactive.example.adapter.infrastructure.r2dbc.ReactiveUserRepository
import io.parkbh.reactive.example.domain.User
import io.parkbh.reactive.example.domain.vo.UserInformation
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataR2dbcTest
internal class R2dbcUserRepositoryTest {

    @Autowired
    lateinit var reactiveUserRepository: ReactiveUserRepository

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun create() {
        runTest {

//            val result = reactiveUserRepository.existsByUserId(id = "parkskrk").awaitSingle()
//            if (!result) {
                reactiveUserRepository.save(
                    User(
                        userId = "parkskrk",
                        address1 = "",
                        address2 = "",
                        phone1 = "",
                        phone2 = "",
                        password = "papa"

                    )
                ).awaitSingle()
//            }
        }
    }

    @Test
    fun update() {
    }
}