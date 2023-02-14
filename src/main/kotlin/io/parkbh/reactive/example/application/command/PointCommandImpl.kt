package io.parkbh.reactive.example.application.command

import io.parkbh.reactive.example.adapter.web.dto.EarnPointDto
import io.parkbh.reactive.example.adapter.web.dto.UsePointDto
import io.parkbh.reactive.example.application.command.usecase.PointCommand
import io.parkbh.reactive.example.application.exception.UserNotFoundException
import io.parkbh.reactive.example.domain.repository.PointRepository
import io.parkbh.reactive.example.domain.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PointCommandImpl(private val userRepository: UserRepository, private val pointRepository: PointRepository) : PointCommand {

    @Transactional
    override suspend fun earn(dto: EarnPointDto) {
        userRepository.findById(id = dto.userId)?.let { user ->
            if (user.point == null) {
                user.createPoint(dto.point)
            } else {
                user.point?.earn(earnPoint = dto.point)
            }

            pointRepository.update(user.point!!)

        } ?: throw UserNotFoundException("")
    }

    override suspend fun use(dto: UsePointDto) {
        userRepository.findById(id = dto.userId)?.let { user ->
            user.point?.use(usePoint = dto.point)
        } ?: throw UserNotFoundException("")
    }

}