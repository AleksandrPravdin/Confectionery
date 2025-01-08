package com.example.confectionery.domain.repository

import com.example.confectionery.domain.model.Confectionery
import com.example.confectionery.domain.model.Consistency

interface ConfectioneryRepository {
    suspend fun getConfectionery(): List<Confectionery>
    suspend fun deleteConfectionery(id: Int)

    suspend fun updateConfectionery(id: Int, confectionery: Confectionery)

    suspend fun addConfectionery(confectionery: Confectionery)

    }