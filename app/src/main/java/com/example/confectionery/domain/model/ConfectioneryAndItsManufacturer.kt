package com.example.confectionery.domain.model

data class ConfectioneryAndItsManufacturer(
    val confAndItsManufId: Int,
    val manufacturer: Manufacturer,
    val confectioneryType: ConfectioneryType
)