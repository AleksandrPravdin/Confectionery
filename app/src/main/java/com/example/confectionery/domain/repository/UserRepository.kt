package com.example.confectionery.domain.repository

import com.example.confectionery.domain.model.Consistency
import com.example.confectionery.domain.model.User

interface UserRepository {
    suspend fun getUser(): List<User>

}