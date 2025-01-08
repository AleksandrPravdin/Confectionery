package com.example.confectionery.domain.repository

import com.example.confectionery.domain.model.ConfManuf
import com.example.confectionery.domain.model.Consistency

interface ConfManufRepository {
    suspend fun getConfManuf(): List<ConfManuf>
}