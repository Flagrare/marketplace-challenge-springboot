package com.example.marketplace.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Category(
    @Id
    val id: String? = null,
    var name: String,
    var desc: String? = null
)
