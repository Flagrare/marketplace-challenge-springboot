package com.example.marketplace.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Sale(
    @Id
    val id: String? = null,
    @Indexed
    var buyer: Buyer,
    @Indexed
    var product: Product,
    @Indexed
    val creationDate: LocalDateTime = LocalDateTime.now()
)
