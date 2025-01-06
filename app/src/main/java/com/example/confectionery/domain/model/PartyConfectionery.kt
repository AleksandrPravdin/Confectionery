package com.example.confectionery.domain.model

data class PartyConfectionery(
    val partyConfId: Int,
    val characteristics: CharacteristicsOfConfectionery,
    val composition: CompositionOfConfectionery,
    val confectioneryAndManufacturer: ConfectioneryAndItsManufacturer,
    val dateOfManufacture: String,
    val count: Int
)