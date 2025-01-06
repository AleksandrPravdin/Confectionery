package com.example.confectionery.data.repository

import com.example.confectionery.domain.model.PartyConfectionery
import com.example.confectionery.domain.repository.PartyConfectioneryRepository

class FakePartyConfectioneryRepository : PartyConfectioneryRepository {
    override suspend fun getPartyConfectioneries(): List<PartyConfectionery> {
        return getSamplePartyConfectioneries()
    }

}
