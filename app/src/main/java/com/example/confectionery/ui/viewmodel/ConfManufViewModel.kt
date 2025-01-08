package com.example.confectionery.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confectionery.data.repository.ConfManufRepositoryImpl
import com.example.confectionery.data.repository.ConsistencyRepositoryImpl
import com.example.confectionery.domain.model.ConfManuf
import com.example.confectionery.domain.model.Consistency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfManufViewModel @Inject constructor(
    private val confManufRepositoryImpl: ConfManufRepositoryImpl
) : ViewModel() {
    private val _confManuf = MutableStateFlow<List<ConfManuf>>(emptyList())
    val confManuf: StateFlow<List<ConfManuf>> = _confManuf

    init {
        getConfMAnuf()
    }

    private fun getConfMAnuf() {
        viewModelScope.launch {
            try {
                _confManuf.value = confManufRepositoryImpl.getConfManuf()
            } catch (
                e: Exception
            ) {
                e.printStackTrace()
            }
        }
    }
}