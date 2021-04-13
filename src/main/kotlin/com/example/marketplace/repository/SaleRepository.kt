package com.example.marketplace.repository

import com.example.marketplace.entity.Sale
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import java.time.LocalDateTime

interface SaleRepository : MongoRepository<Sale, String> {
    @Query("{ product: { productId: ?0 } }")
    fun findByProductId(productId: String, sort: Sort): MutableList<Sale>

    @Query("""{ 
            product: { productId: ?0}
            buyer: { 
                User: { id: ?1 }
             }
        }""")
    fun findByProductAndClient(productId: String, buyerId: String, sort: Sort): Sale


}
