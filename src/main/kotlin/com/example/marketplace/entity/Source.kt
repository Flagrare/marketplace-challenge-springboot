package com.example.marketplace.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Source(
    @Id
    var id: String? = null,
    var name: String
)
