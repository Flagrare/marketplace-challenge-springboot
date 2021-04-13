package com.example.marketplace.controller

import com.example.marketplace.data.NewsVO
import com.example.marketplace.service.NewsService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("news")
internal class NewsController(val newsService: NewsService) {
    @GetMapping
    fun forceNewsUpdate(): ResponseEntity<Unit> {
        return ResponseEntity.ok(newsService.consumeNews())
    }
}