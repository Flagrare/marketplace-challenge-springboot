package com.example.marketplace.data

import com.example.marketplace.entity.Rating
import com.example.marketplace.entity.Sale

class RatingVO(
    val rate: Int,
    val sale: Sale
) {
    companion object {
        fun fromEntity(rating: Rating): RatingVO =
            RatingVO(
                rate = rating.rate,
                sale = rating.sale
            )
    }
}

