package com.example.confectionery.data.repository

import com.example.confectionery.data.remote.api.ConfectioneryApi
import com.example.confectionery.data.remote.mapper.toDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.confectionery.domain.model.PartyConfectionery
import com.example.confectionery.domain.repository.PartyConfectioneryRepository

class PartyConfectioneryRepositoryImpl(private val api: ConfectioneryApi) :
    PartyConfectioneryRepository {
    override suspend fun getParty(page: Int, size: Int): List<PartyConfectionery> {
        val response = api.getPartyConfectionery(page, size)
        return response.content.map { it.toDomainModel() }
    }

    override suspend fun addParty(partyConfectionery: PartyConfectionery) =
        withContext(Dispatchers.IO) { api.addPartyConfectionery(partyConfectionery) }

    override suspend fun deleteParty(id: Int) {
        withContext(Dispatchers.IO) { api.deletePartyConfectionery(id) }
    }

    override suspend fun getPartyById(id: Int): PartyConfectionery {
        return api.getPartyConfectioneryById(id).toDomainModel()
    }
}