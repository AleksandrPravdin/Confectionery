package com.example.confectionery.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.confectionery.domain.repository.PartyConfectioneryRepository

class PartyConfectioneryViewModelFactory(
    private val repository: PartyConfectioneryRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PartyConfectioneryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PartyConfectioneryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
