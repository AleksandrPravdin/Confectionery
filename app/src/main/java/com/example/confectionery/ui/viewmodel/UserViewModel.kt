package com.example.confectionery.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confectionery.data.repository.ConsistencyRepositoryImpl
import com.example.confectionery.data.repository.UserRepositoryImpl
import com.example.confectionery.domain.model.Consistency
import com.example.confectionery.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepositoryImpl: UserRepositoryImpl
) : ViewModel() {
    private val _user = MutableStateFlow<List<User>>(emptyList())
    val user: StateFlow<List<User>> = _user

    init {
        getUser()
    }

    private fun getUser() {
        viewModelScope.launch {
            try {
                _user.value = userRepositoryImpl.getUser()
            } catch (
                e: Exception
            ) {
                e.printStackTrace()
            }
        }
    }

    fun registerUser(login: String, password: String) {
        viewModelScope.launch {
            try {
                val user = User(userId = 999, login = login, password = password, role = "def")
                userRepositoryImpl.createUser(user)
                getUser()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}