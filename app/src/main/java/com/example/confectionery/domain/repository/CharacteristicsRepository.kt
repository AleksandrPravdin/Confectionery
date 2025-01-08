package com.example.confectionery.domain.repository

import com.example.confectionery.domain.model.Characteristics
import com.example.confectionery.domain.model.Consistency

interface CharacteristicsRepository {
    suspend fun getCharacteristics(): List<Characteristics>

}