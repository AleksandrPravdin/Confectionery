package com.example.confectionery.data.repository

import com.example.confectionery.data.remote.api.ConfectioneryApi
import com.example.confectionery.data.remote.mapper.toDomainModel
import com.example.confectionery.domain.model.User
import com.example.confectionery.domain.repository.UserRepository

class UserRepositoryImpl(private val api:ConfectioneryApi):UserRepository {
    override suspend fun getUser(): List<User> {
        return api.getUser().map { it.toDomainModel() }
    }
    suspend fun createUser(user: User) {
        api.createUser(user)
    }
}