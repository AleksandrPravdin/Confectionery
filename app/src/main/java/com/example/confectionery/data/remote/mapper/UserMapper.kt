package com.example.confectionery.data.remote.mapper

import com.example.confectionery.data.remote.dto.ConsistencyDTO
import com.example.confectionery.data.remote.dto.UserDTO
import com.example.confectionery.domain.model.Consistency
import com.example.confectionery.domain.model.User

fun UserDTO.toDomainModel(): User {
    return User(
        userId=this.userId,
        login=this.login,
        password=this.password,
        role=this.role
    )
}