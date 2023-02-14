package io.parkbh.reactive.example.adapter.infrastructure.r2dbc

import io.parkbh.reactive.example.domain.Point
import io.parkbh.reactive.example.domain.repository.PointRepository
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

interface ReactivePointRepository : ReactiveCrudRepository<Point, String> {
    
}

@Repository
class R2dbcPointRepository(val reactiveRepository: ReactivePointRepository) : PointRepository {

    override suspend fun update(point: Point) {
        reactiveRepository.save(point).awaitSingle()
    }
}