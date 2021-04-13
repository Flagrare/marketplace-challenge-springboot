package com.example.marketplace.dto

import com.example.marketplace.entity.Category

data class CategoryDTO(
    var name: String,
    var desc: String? = null,
)
