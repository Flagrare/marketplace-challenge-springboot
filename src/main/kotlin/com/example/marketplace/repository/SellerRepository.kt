package com.example.marketplace.repository

import com.example.marketplace.entity.Buyer
import com.example.marketplace.entity.Seller
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface SellerRepository : MongoRepository<Seller, String>{
    @Query("{ user: {id: ?0}}")
    fun findByUserId(userId: String): Seller
}