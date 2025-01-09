package com.example.confectionery.data.remote.dto

data class PagedResponse<T>(
    val content: List<T>,
    val pageable: Pageable,
    val totalElements: Int,
    val totalPages: Int,
    val size: Int,
    val number: Int,
    val numberOfElements: Int,
    val first: Boolean,
    val last: Boolean,
    val empty: Boolean
)

data class Pageable(
    val pageNumber: Int,
    val pageSize: Int,
    val offset: Int,
    val paged: Boolean,
    val unpaged: Boolean
)
