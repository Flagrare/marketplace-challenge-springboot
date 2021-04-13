package com.example.marketplace.entity

import org.springframework.data.annotation.Id

data class Seller(
    @Id
    val id: String? = null,
    var user: User
)
