package com.example.confectionery.data.repository

import com.example.confectionery.data.remote.api.ConfectioneryApi
import com.example.confectionery.data.remote.mapper.toDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.confectionery.domain.model.PartyConfectionery
import com.example.confectionery.domain.repository.PartyConfectioneryRepository

class PartyConfectioneryRepositoryImpl(private val api: ConfectioneryApi) :
    PartyConfectioneryRepository {
    override suspend fun getParty(): List<PartyConfectionery> {
        return api.getPartyConfectionery().map { it.toDomainModel() }
    }

    override suspend fun addParty(partyConfectionery: PartyConfectionery) =
        withContext(Dispatchers.IO) { api.addPartyConfectionery(partyConfectionery) }

    override suspend fun deleteParty(id: Int) {
        withContext(Dispatchers.IO) { api.deletePartyConfectionery(id) }
    }
}