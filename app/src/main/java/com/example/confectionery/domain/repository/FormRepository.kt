package com.example.confectionery.domain.repository

import com.example.confectionery.domain.model.Form

interface FormRepository {
    suspend fun getForm(): List<Form>
}