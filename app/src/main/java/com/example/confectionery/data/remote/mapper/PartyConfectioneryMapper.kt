package com.example.confectionery.data.remote.mapper

import com.example.confectionery.data.remote.dto.PartyConfectioneryDTO
import com.example.confectionery.domain.model.PartyConfectionery

fun PartyConfectioneryDTO.toDomainModel(): PartyConfectionery {
    return PartyConfectionery(
        partyConfId = this.partyConfId,
        compositionId = this.compositionId,
        characteristicsId = this.characteristicsId,
        confAndItsManufId = this.confAndItsManufId,
        dateOfManufactureId = this.dateOfManufactureId,
        count = this.count
    )
}