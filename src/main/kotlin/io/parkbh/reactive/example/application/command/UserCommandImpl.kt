package io.parkbh.reactive.example.application.command

import io.parkbh.reactive.example.adapter.web.dto.RegisterUserDto
import io.parkbh.reactive.example.adapter.web.dto.UpdateUserDto
import io.parkbh.reactive.example.application.command.usecase.UserCommand
import io.parkbh.reactive.example.application.exception.UserExistsException
import io.parkbh.reactive.example.domain.User
import io.parkbh.reactive.example.domain.repository.UserRepository
import io.parkbh.reactive.example.domain.vo.UserInformation
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
class UserCommandImpl(val userRepository: UserRepository) : UserCommand {

    @Transactional
    override suspend fun register(dto: RegisterUserDto) {
        if (userRepository.exists(id = dto.userId)) {
            throw UserExistsException(message = dto.userId)
        } else {
            userRepository.create(
                User(
                    userId = dto.userId,
                    address1 = dto.address1,
                    address2 = dto.address2,
                    phone1 = dto.phone1,
                    phone2 = dto.phone2,
                    password = dto.password
                )
            )
        }

    }

    override suspend fun update(dto: UpdateUserDto) {
        TODO("Not yet implemented")
    }

}