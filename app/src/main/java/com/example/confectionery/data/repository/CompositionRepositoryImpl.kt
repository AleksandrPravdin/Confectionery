package com.example.confectionery.data.repository

import com.example.confectionery.data.remote.api.ConfectioneryApi
import com.example.confectionery.domain.repository.CompositionRepository
import com.example.confectionery.data.remote.mapper.toDomainModel
import com.example.confectionery.domain.model.Composition

class CompositionRepositoryImpl(private val api: ConfectioneryApi):CompositionRepository {
    override suspend fun getCompositions(): List<Composition> {
        return api.getCompositions().map { it.toDomainModel() }
    }
}