package com.example.confectionery.domain.model

data class Composition(
    val compositionId: Int,
    val proteins: Double,
    val fats: Double,
    val carbohydrates: Double,
    val listOfProducts: String
)