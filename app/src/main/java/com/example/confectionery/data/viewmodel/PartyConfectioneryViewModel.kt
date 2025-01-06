package com.example.confectionery.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confectionery.data.repository.PartyConfectioneryRepositoryImpl
import com.example.confectionery.domain.model.PartyConfectionery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PartyConfectioneryViewModel @Inject constructor(
    private val repository: PartyConfectioneryRepositoryImpl
) : ViewModel() {

    private val _partyConfectioneries = MutableStateFlow<List<PartyConfectionery>>(emptyList())
    val partyConfectioneries: StateFlow<List<PartyConfectionery>> = _partyConfectioneries

    init {
        getParty()
    }

    private fun getParty() {
        viewModelScope.launch { _partyConfectioneries.value = repository.getParty() }
    }
    private fun addParty(){
        viewModelScope.launch {  }
    }
    private fun deleteParty(){
        viewModelScope.launch {  }
    }
}
