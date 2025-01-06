package com.example.confectionery.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confectionery.domain.model.PartyConfectionery
import com.example.confectionery.domain.repository.PartyConfectioneryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PartyConfectioneryViewModel(
    private val repository: PartyConfectioneryRepository
) : ViewModel() {

    private val _partyConfectioneries = MutableStateFlow<List<PartyConfectionery>>(emptyList())
    val partyConfectioneries: StateFlow<List<PartyConfectionery>> = _partyConfectioneries

    init {
        fetchPartyConfectioneries()
    }

    private fun fetchPartyConfectioneries() {
        viewModelScope.launch {
            val data = repository.getPartyConfectioneries()
            _partyConfectioneries.value = data
        }
    }
}
