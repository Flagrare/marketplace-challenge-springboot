package com.example.marketplace.data

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("products")
data class Product (
    @Id
    val id: String? = null,
    var name: String,
    var desc: String,
    val score: Long? = 0,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val updateDate: LocalDateTime = LocalDateTime.now()
)