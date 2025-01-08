package com.example.confectionery.data.repository

import com.example.confectionery.data.remote.api.ConfectioneryApi
import com.example.confectionery.data.remote.mapper.toDomainModel
import com.example.confectionery.domain.model.Confectionery
import com.example.confectionery.domain.model.Consistency
import com.example.confectionery.domain.model.Manufacturer
import com.example.confectionery.domain.repository.ConsistencyRepository
import com.example.confectionery.domain.repository.ManufacturerRepository

class ManufacturerRepositoryImpl (private val api: ConfectioneryApi) : ManufacturerRepository {
    override suspend fun getManufacturer(): List<Manufacturer> {
        return api.getManufacturer().map { it.toDomainModel() }
    }
    override suspend fun deleteManufacturer(id: Int) {
        api.deleteManufacturer(id)
    }

    override suspend fun updateManufacturer(id: Int, manufacturer: Manufacturer) {
        api.updateManufacturer(id, manufacturer)
    }

    override suspend fun addManufacturer(manufacturer: Manufacturer) {
        api.addManufacturer(manufacturer)
    }
}