package com.example.marketplace.dto

import com.example.marketplace.entity.Category

data class ProductDTO(
    var name: String,
    var desc: String,
    var category: Category,
    var userId: String
)
