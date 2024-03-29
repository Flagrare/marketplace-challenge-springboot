package com.example.marketplace.controller

import com.example.marketplace.data.RatingVO
import com.example.marketplace.dto.RatingDTO
import com.example.marketplace.service.RatingService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger

@RestController
@RequestMapping("rating")
internal class RatingController(val ratingService: RatingService) {

    val logger: Logger = Logger.getLogger(RatingController::class.java.canonicalName)

    @PostMapping
    fun rateProduct(@RequestBody ratingDTO: RatingDTO): ResponseEntity<RatingVO> {
        val rating = ratingService.rateProduct(ratingDTO)
        logger.info("Rating done $rating")
        return ResponseEntity
            .ok(
                RatingVO.fromEntity(rating)
            )
    }

    @GetMapping
    fun getAllPurchases(): ResponseEntity<List<RatingVO>> {
        val rates = ratingService.findAll()
        return ResponseEntity
            .ok(
                rates.map { RatingVO.fromEntity(it) }
            )
    }

    @GetMapping("/{id}")
    fun getCategoryDetail(@PathVariable("id") id: String): ResponseEntity<RatingVO> {

        val rate = ratingService.findById(id)
        logger.info("Rate $rate")

        return ResponseEntity.ok(RatingVO.fromEntity(rate))

    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: String): ResponseEntity<Void> {
        ratingService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}