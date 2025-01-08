package com.example.confectionery.data.repository

import com.example.confectionery.data.remote.api.ConfectioneryApi
import com.example.confectionery.data.remote.mapper.toDomainModel
import com.example.confectionery.domain.model.Confectionery
import com.example.confectionery.domain.repository.ConfectioneryRepository

class ConfectioneryRepositoryImpl(private val api: ConfectioneryApi) : ConfectioneryRepository {
    override suspend fun getConfectionery(): List<Confectionery> {
        return api.getConfectionery().map { it.toDomainModel() }
    }

    override suspend fun deleteConfectionery(id: Int) {
        api.deleteConfectionery(id)
    }

    override suspend fun updateConfectionery(id: Int, confectionery: Confectionery) {
        api.updateConfectionery(id, confectionery)
    }

    override suspend fun addConfectionery(confectionery: Confectionery) {
        api.addConfectionery(confectionery)
    }

}