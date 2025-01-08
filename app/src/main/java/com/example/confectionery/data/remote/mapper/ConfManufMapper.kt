package com.example.confectionery.data.remote.mapper

import com.example.confectionery.data.remote.dto.ConfManufDTO
import com.example.confectionery.data.remote.dto.ConsistencyDTO
import com.example.confectionery.domain.model.ConfManuf
import com.example.confectionery.domain.model.Consistency

fun ConfManufDTO.toDomainModel(): ConfManuf {
    return ConfManuf(
        confAndItsManufId = this.confAndItsManufId,
        manufacturerId = this.manufacturerId,
        confectioneryId = this.confectioneryId
    )
}