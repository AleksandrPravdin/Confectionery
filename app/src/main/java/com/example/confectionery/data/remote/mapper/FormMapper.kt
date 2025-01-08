package com.example.confectionery.data.remote.mapper

import com.example.confectionery.data.remote.dto.ConsistencyDTO
import com.example.confectionery.data.remote.dto.FormDTO
import com.example.confectionery.domain.model.Consistency
import com.example.confectionery.domain.model.Form

fun FormDTO.toDomainModel(): Form {
    return Form(
        formId = this.formId,
        form = this.form
    )
}