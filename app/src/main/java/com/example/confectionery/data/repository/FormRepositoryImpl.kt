package com.example.confectionery.data.repository

import com.example.confectionery.data.remote.api.ConfectioneryApi
import com.example.confectionery.data.remote.mapper.toDomainModel
import com.example.confectionery.domain.model.Form
import com.example.confectionery.domain.repository.FormRepository

class FormRepositoryImpl(private val api: ConfectioneryApi) : FormRepository {
    override suspend fun getForm(): List<Form> {
        return api.getForm().map { it.toDomainModel() }
    }
}