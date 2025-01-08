package com.example.confectionery.domain.repository

import com.example.confectionery.domain.model.Confectionery
import com.example.confectionery.domain.model.Consistency

interface ConfectioneryRepository {
    suspend fun getConfectionery(): List<Confectionery>
}