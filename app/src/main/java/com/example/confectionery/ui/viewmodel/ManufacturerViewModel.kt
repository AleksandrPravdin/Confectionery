package com.example.confectionery.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confectionery.data.repository.ManufacturerRepositoryImpl
import com.example.confectionery.domain.model.Confectionery
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

    fun deleteManufacturer(id: Int) {
        viewModelScope.launch {
            try {
                repository.deleteManufacturer(id)
                getManufacturer()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun updateManufacturer(id: Int, name: String, address: String) {
        viewModelScope.launch {
            try {
                val updatedManufacturer = Manufacturer(id, name, address)
                repository.updateManufacturer(id, updatedManufacturer)
                getManufacturer()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun addManufacturer(id: Int, name: String, address: String) {
        viewModelScope.launch {
            try {
                val newManufacturer = Manufacturer(id, name, address)
                repository.addManufacturer(newManufacturer)
                getManufacturer()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}