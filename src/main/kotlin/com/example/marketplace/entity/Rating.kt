package com.example.marketplace.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Rating(
    @Id
    val id: String? = null,
    val rate: Int,
    val sale: Sale,
    @Indexed
    val ratingDate: LocalDateTime = LocalDateTime.now(),
)
