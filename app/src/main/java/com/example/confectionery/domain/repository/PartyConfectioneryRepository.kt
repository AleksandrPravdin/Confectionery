package com.example.confectionery.domain.repository

import com.example.confectionery.domain.model.PartyConfectionery

interface PartyConfectioneryRepository {
    suspend fun getPartyConfectioneries(): List<PartyConfectionery>
}
