package com.example.confectionery.data.remote.mapper

import com.example.confectionery.data.remote.dto.CompositionDTO
import com.example.confectionery.domain.model.Composition

fun CompositionDTO.toDomainModel(): Composition {
    return Composition(
        compositionId = this.compositionId,
        proteins = this.proteins,
        fats = this.fats,
        carbohydrates = this.carbohydrates,
        listOfProducts = this.listOfProducts
    )
}