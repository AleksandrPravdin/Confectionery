package com.example.confectionery.data.remote.mapper

import com.example.confectionery.data.remote.dto.CompositionDTO
import com.example.confectionery.data.remote.dto.ConsistencyDTO
import com.example.confectionery.domain.model.Composition
import com.example.confectionery.domain.model.Consistency

fun ConsistencyDTO.toDomainModel(): Consistency {
    return Consistency(
        consistencyId = this.consistencyId,
        consistency = this.consistency
    )
}