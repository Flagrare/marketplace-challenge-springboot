package com.example.marketplace.dto

import com.example.marketplace.entity.Category
import com.example.marketplace.entity.Product

data class RatingDTO(
    var productId: String,
    var userId: String,
    var rate: Int
)
