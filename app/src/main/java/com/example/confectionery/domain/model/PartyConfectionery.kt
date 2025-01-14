package com.example.confectionery.domain.model

import java.util.Date

data class PartyConfectionery(
    val partyConfId: Int,
    val compositionId: Int,
    val characteristicsId: Int,
    val confAndItsManufId: Int,
    val dateOfManufactureId: Date,
    val count: Int
)