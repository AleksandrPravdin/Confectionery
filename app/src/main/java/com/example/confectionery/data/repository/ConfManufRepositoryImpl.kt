package com.example.confectionery.data.repository

import com.example.confectionery.data.remote.api.ConfectioneryApi
import com.example.confectionery.data.remote.mapper.toDomainModel
import com.example.confectionery.domain.model.ConfManuf
import com.example.confectionery.domain.repository.ConfManufRepository

class ConfManufRepositoryImpl(private val api:ConfectioneryApi):ConfManufRepository {
    override suspend fun getConfManuf(): List<ConfManuf> {
        return api.getConfManuf().map { it.toDomainModel() }
    }
}