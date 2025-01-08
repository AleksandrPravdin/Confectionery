package com.example.confectionery.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confectionery.data.repository.ConfectioneryRepositoryImpl
import com.example.confectionery.domain.model.Confectionery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfectioneryViewModel @Inject constructor(
    private val confectioneryRepositoryImpl: ConfectioneryRepositoryImpl
) : ViewModel() {
    private val _confectionery = MutableStateFlow<List<Confectionery>>(emptyList())
    val confectionery: StateFlow<List<Confectionery>> = _confectionery

    init {
        getConfectionery()
    }

    private fun getConfectionery() {
        viewModelScope.launch {
            try {
                _confectionery.value = confectioneryRepositoryImpl.getConfectionery()
            } catch (
                e: Exception
            ) {
                e.printStackTrace()
            }
        }
    }
}