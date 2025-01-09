package com.example.confectionery.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confectionery.data.remote.dto.PartyConfectioneryDTO
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
) : ViewModel()  {

    private val _partyConfectioneries = MutableStateFlow<List<PartyConfectionery>>(emptyList())
    val partyConfectioneries: StateFlow<List<PartyConfectionery>> = _partyConfectioneries

    private val _partyConfectioneryDetail = MutableStateFlow<PartyConfectionery?>(null)
    val partyConfectioneryDetail: StateFlow<PartyConfectionery?> = _partyConfectioneryDetail

    private var currentPage = 0
    private val pageSize = 10
    private var isLoading = false

    init {
        loadNextPage()
    }
    fun loadPartyConfectioneryDetail(partyConfId: Int) {
        viewModelScope.launch {
            try {
                val detail = repository.getPartyById(partyConfId)
                _partyConfectioneryDetail.value = detail
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun loadNextPage() {
        if (isLoading) return
        isLoading = true
        viewModelScope.launch {
            try {
                val newData = repository.getParty(currentPage, pageSize)
                _partyConfectioneries.value = _partyConfectioneries.value + newData
                currentPage++
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                isLoading = false
            }
        }
    }
}
