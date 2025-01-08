package com.example.confectionery.data.remote.dto

data class CompositionDTO(
    val compositionId: Int,
    val proteins: Double,
    val fats: Double,
    val carbohydrates: Double,
    val listOfProducts: String
)