package com.example.confectionery.data.remote.dto

import java.util.Date

data class PartyConfectioneryDTO(
    val partyConfId: Int,
    val compositionId: Int,
    val characteristicsId: Int,
    val confAndItsManufId: Int,
    val dateOfManufactureId: Date,
    val count: Int
)
