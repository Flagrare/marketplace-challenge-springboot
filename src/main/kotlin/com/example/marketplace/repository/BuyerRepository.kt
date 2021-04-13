package com.example.marketplace.repository

import com.example.marketplace.entity.Buyer
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface BuyerRepository : MongoRepository<Buyer, String> {
    @Query("{ user: {id: ?0}}")
    fun findByUserId(userId: String): Buyer
}