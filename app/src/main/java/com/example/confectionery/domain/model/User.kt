package com.example.confectionery.domain.model

data class User(
    val userId: Int,
    val login: String,
    val password: String,
    val role: String
)