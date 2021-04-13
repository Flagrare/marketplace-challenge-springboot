package com.example.marketplace.entity

import org.springframework.data.annotation.Id

data class Category(
    @Id
    val id: String? = null,
    var name: String,
    var desc: String? = null
)
