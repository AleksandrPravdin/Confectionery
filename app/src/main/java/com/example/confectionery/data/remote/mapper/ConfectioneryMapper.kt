package com.example.confectionery.data.remote.mapper

import com.example.confectionery.data.remote.dto.ConfectioneryDTO
import com.example.confectionery.data.remote.dto.ConsistencyDTO
import com.example.confectionery.domain.model.Confectionery
import com.example.confectionery.domain.model.Consistency

fun ConfectioneryDTO.toDomainModel(): Confectionery {
    return Confectionery(
        confectioneryId = this.confectioneryId,
        name = this.name
    )
}