package com.example.confectionery.domain.repository

import com.example.confectionery.data.remote.dto.CompositionDTO
import com.example.confectionery.data.remote.dto.PartyConfectioneryDTO
import com.example.confectionery.domain.model.Composition

interface CompositionRepository {
    suspend fun getCompositions(): List<Composition>
}