package com.example.confectionery.data.repository

import com.example.confectionery.data.remote.api.ConfectioneryApi
import com.example.confectionery.data.remote.mapper.toDomainModel
import com.example.confectionery.domain.model.Characteristics
import com.example.confectionery.domain.repository.CharacteristicsRepository

class CharacteristicsRepositoryImpl(private val api: ConfectioneryApi) : CharacteristicsRepository {
    override suspend fun getCharacteristics(): List<Characteristics> {
        return api.getCharacteristics().map { it.toDomainModel() }
    }
}