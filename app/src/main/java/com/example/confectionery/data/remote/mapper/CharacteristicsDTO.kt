package com.example.confectionery.data.remote.mapper

import com.example.confectionery.data.remote.dto.CharacteristicsDTO
import com.example.confectionery.data.remote.dto.CompositionDTO
import com.example.confectionery.domain.model.Characteristics
import com.example.confectionery.domain.model.Composition

fun CharacteristicsDTO.toDomainModel(): Characteristics {
    return Characteristics(
        characteristicsId = this.characteristicsId,
        formId = this.formId,
        consistencyId = this.consistencyId,
        size = this.size
    )
}