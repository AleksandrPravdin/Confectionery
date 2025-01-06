package com.example.confectionery.domain.model

data class CompositionOfConfectionery(
    val compositionId: Int,
    val proteins: Float,
    val fats: Float,
    val carbohydrates: Float,
    val listOfProducts: String
)