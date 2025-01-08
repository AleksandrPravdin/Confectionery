package com.example.confectionery.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confectionery.data.repository.FormRepositoryImpl
import com.example.confectionery.domain.model.Form
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(
    private val formRepositoryImpl: FormRepositoryImpl
) : ViewModel() {
    private val _form = MutableStateFlow<List<Form>>(emptyList())
    val form: StateFlow<List<Form>> = _form

    init {
        getForm()
    }

    private fun getForm() {
        viewModelScope.launch {
            try {
                _form.value = formRepositoryImpl.getForm()
            } catch (
                e: Exception
            ) {
                e.printStackTrace()
            }
        }
    }
}