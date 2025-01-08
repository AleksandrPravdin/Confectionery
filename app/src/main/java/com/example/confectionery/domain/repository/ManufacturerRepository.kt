package com.example.confectionery.domain.repository

import com.example.confectionery.domain.model.Consistency
import com.example.confectionery.domain.model.Manufacturer

interface ManufacturerRepository{
    suspend fun getManufacturer(): List<Manufacturer>
}