package com.example.marketplace.repository

import com.example.marketplace.entity.Article
import com.example.marketplace.entity.Category
import com.example.marketplace.entity.Rating
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import java.time.LocalDateTime

interface ArticleRepository : MongoRepository<Article, String> {
    @Query(
        """{
                category: { _id: ?0  },
                creationDate: ?1
    } """
    )
    fun findAllByCategoryFromToday(categoryId: String, today: LocalDateTime): MutableList<Article>
}