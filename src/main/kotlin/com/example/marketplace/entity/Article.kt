package com.example.marketplace.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Article(
    var source: Source,
    var author: String? = null,
    var title: String? = null,
    var description: String? = null,
    var url: String? = null,
    var urlToImage: String? = null,
    var publishedAt: String? = null,
    var content: String? = null,
    var category: Category? = null
)