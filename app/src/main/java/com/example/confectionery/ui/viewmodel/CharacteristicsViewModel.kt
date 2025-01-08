package com.example.confectionery.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confectionery.data.repository.CharacteristicsRepositoryImpl
import com.example.confectionery.domain.model.Characteristics
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacteristicsViewModel @Inject constructor(
    private val characteristicsRepositoryImpl: CharacteristicsRepositoryImpl
) : ViewModel() {
    private val _characteristics = MutableStateFlow<List<Characteristics>>(emptyList())
    val characteristics: StateFlow<List<Characteristics>> = _characteristics

    init {
        getCharacteristics()
    }

    private fun getCharacteristics() {
        viewModelScope.launch {
            try {
                _characteristics.value = characteristicsRepositoryImpl.getCharacteristics()
            } catch (
                e: Exception
            ) {
                e.printStackTrace()
            }
        }
    }
}