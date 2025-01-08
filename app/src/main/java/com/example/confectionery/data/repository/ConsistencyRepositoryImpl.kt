package com.example.confectionery.data.repository

import com.example.confectionery.data.remote.api.ConfectioneryApi
import com.example.confectionery.data.remote.mapper.toDomainModel
import com.example.confectionery.domain.model.Consistency
import com.example.confectionery.domain.repository.ConsistencyRepository

class ConsistencyRepositoryImpl(private val api: ConfectioneryApi) : ConsistencyRepository {
    override suspend fun getConsistency(): List<Consistency> {
        return api.getConsistency().map { it.toDomainModel() }
    }
}