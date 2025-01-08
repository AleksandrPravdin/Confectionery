package com.example.confectionery.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confectionery.data.repository.CompositionRepositoryImpl
import com.example.confectionery.domain.model.Composition
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompositionViewModel @Inject constructor(
    private val repository: CompositionRepositoryImpl
) : ViewModel() {

    private val _compositions = MutableStateFlow<List<Composition>>(emptyList())
    val compositions: StateFlow<List<Composition>> = _compositions

    init {
        getCompositions()
    }

    private fun getCompositions() {
        viewModelScope.launch {
            try {
                _compositions.value = repository.getCompositions()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
