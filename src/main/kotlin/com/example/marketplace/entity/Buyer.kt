package com.example.marketplace.entity

import org.springframework.data.annotation.Id

data class Buyer(
    @Id
    val id: String? = null,
    var user: User
)
