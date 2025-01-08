package com.example.confectionery.domain.repository

import com.example.confectionery.data.remote.dto.PartyConfectioneryDTO
import com.example.confectionery.domain.model.PartyConfectionery

interface PartyConfectioneryRepository {
    suspend fun getParty(): List<PartyConfectionery>
    suspend fun addParty(partyConfectionery: PartyConfectionery): PartyConfectionery
    suspend fun deleteParty(id: Int)
}
