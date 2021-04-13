package com.example.marketplace.service

import com.example.marketplace.Categories
import com.example.marketplace.Endpoints
import com.example.marketplace.data.NewsVO
import com.example.marketplace.repository.ArticleRepository
import com.example.marketplace.repository.CategoryRepository
import com.example.marketplace.repository.ProductRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class NewsService(val articleRepository: ArticleRepository, val categoryRepository: CategoryRepository) {

    @Scheduled(cron = "0 0 */4 * * *")
    fun consumeNews() {

//        val categories = Categories.javaClass.fields
        val categories = categoryRepository.findAll()

        categories.forEach { category ->

            var newsResponseObject: NewsVO? = RestTemplate().getForObject(
                Endpoints.NEWS_API_URL_WITH_CATEGORY + category.name,
                NewsVO::class.java
            )

            var articlesList =
                newsResponseObject?.articles?.toMutableList()

            if (articlesList != null) {

                articlesList.forEach { article ->
                    article.category = category
                }

                articleRepository.saveAll(articlesList)
            }
        }
    }
}