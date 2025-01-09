package com.example.confectionery.domain.repository

import com.example.confectionery.data.remote.dto.PartyConfectioneryDTO
import com.example.confectionery.domain.model.PartyConfectionery

interface PartyConfectioneryRepository {
    suspend fun getParty(page: Int, size: Int): List<PartyConfectionery>
    suspend fun addParty(partyConfectionery: PartyConfectionery): PartyConfectionery
    suspend fun deleteParty(id: Int)
    suspend fun getPartyById(id: Int): PartyConfectionery

    }
