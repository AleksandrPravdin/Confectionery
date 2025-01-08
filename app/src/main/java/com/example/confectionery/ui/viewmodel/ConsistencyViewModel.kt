package com.example.confectionery.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confectionery.data.repository.ConsistencyRepositoryImpl
import com.example.confectionery.domain.model.Consistency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConsistencyViewModel @Inject constructor(
    private val consistencyRepositoryImpl: ConsistencyRepositoryImpl
) : ViewModel() {
    private val _consistency = MutableStateFlow<List<Consistency>>(emptyList())
    val consistency: StateFlow<List<Consistency>> = _consistency

    init {
        getConsistency()
    }

    private fun getConsistency() {
        viewModelScope.launch {
            try {
                _consistency.value = consistencyRepositoryImpl.getConsistency()
            } catch (
                e: Exception
            ) {
                e.printStackTrace()
            }
        }
    }
}