package com.example.confectionery.domain.repository

import com.example.confectionery.domain.model.Consistency

interface ConsistencyRepository {
    suspend fun getConsistency(): List<Consistency>
}