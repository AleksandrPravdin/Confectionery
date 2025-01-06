package com.example.confectionery.data.api

import com.example.confectionery.domain.model.PartyConfectionery
import retrofit2.http.*

interface ConfectioneryApi {

    @GET("/api/partyconf")
    suspend fun getPartyConfectionery(): List<PartyConfectionery>

    @POST("/api/partyconf")
    suspend fun addPartyConfectionery(@Body candy: PartyConfectionery): PartyConfectionery

    @DELETE("/api/partyconf/{id}")
    suspend fun deletePartyConfectionery(@Path("id") id: Int)
}