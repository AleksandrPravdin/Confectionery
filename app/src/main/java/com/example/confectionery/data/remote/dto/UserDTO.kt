package com.example.confectionery.data.remote.dto

data class UserDTO(
    val userId: Int,
    val login: String,
    val password: String,
    val role: String
)