package io.parkbh.reactive.example.domain.repository

import io.parkbh.reactive.example.domain.Point

interface PointRepository {
    suspend fun update(point: Point)
}