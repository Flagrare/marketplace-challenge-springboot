package com.example.marketplace.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Buyer(
    @Id
    val id: String? = null,
    var user: User
)
