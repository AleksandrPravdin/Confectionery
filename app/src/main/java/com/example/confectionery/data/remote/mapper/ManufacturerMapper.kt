package com.example.confectionery.data.remote.mapper

import com.example.confectionery.data.remote.dto.ManufacturerDTO
import com.example.confectionery.domain.model.Manufacturer

fun ManufacturerDTO.toDomainModel(): Manufacturer {
    return Manufacturer(
        manufacturerId = this.manufacturerId,
        name = this.name,
        address = this.address
    )
}