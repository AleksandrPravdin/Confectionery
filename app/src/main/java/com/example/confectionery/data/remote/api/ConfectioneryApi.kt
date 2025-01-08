package com.example.confectionery.data.remote.api

import com.example.confectionery.data.remote.dto.CharacteristicsDTO
import com.example.confectionery.data.remote.dto.CompositionDTO
import com.example.confectionery.data.remote.dto.ConfManufDTO
import com.example.confectionery.data.remote.dto.ConfectioneryDTO
import com.example.confectionery.data.remote.dto.ConsistencyDTO
import com.example.confectionery.data.remote.dto.FormDTO
import com.example.confectionery.data.remote.dto.ManufacturerDTO
import com.example.confectionery.data.remote.dto.PartyConfectioneryDTO
import com.example.confectionery.domain.model.PartyConfectionery
import retrofit2.http.*

interface ConfectioneryApi {


    @GET("/api/partyconf")
    suspend fun getPartyConfectionery(): List<PartyConfectioneryDTO>

    @POST("/api/partyconf")
    suspend fun addPartyConfectionery(@Body candy: PartyConfectionery): PartyConfectionery

    @DELETE("/api/partyconf/{id}")
    suspend fun deletePartyConfectionery(@Path("id") id: Int)

    @GET("/api/compositions")
    suspend fun getCompositions(): List<CompositionDTO>

    @GET("/api/consistency")
    suspend fun getConsistency(): List<ConsistencyDTO>
    @GET("/api/manufacturer")
    suspend fun getManufacturer(): List<ManufacturerDTO>
    @GET("/api/form")
    suspend fun getForm(): List<FormDTO>

    @GET("/api/characteristics")
    suspend fun getCharacteristics(): List<CharacteristicsDTO>

    @GET("/api/confmanuf")
    suspend fun getConfManuf(): List<ConfManufDTO>
    @GET("/api/confectionery")
    suspend fun getConfectionery(): List<ConfectioneryDTO>
}