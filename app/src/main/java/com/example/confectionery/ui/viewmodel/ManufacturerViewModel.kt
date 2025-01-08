package com.example.confectionery.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confectionery.data.repository.ManufacturerRepositoryImpl
import com.example.confectionery.domain.model.Manufacturer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ManufacturerViewModel @Inject constructor(
    private val repository: ManufacturerRepositoryImpl
) : ViewModel() {

    private val _manufacturer = MutableStateFlow<List<Manufacturer>>(emptyList())
    val manufacturer: StateFlow<List<Manufacturer>> = _manufacturer

    init {
        getManufacturer()
    }

    private fun getManufacturer() {
        viewModelScope.launch {
            try {
                _manufacturer.value = repository.getManufacturer()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}