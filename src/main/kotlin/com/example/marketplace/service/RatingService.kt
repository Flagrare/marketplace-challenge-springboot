package com.example.marketplace.service

import com.example.marketplace.dto.RatingDTO
import com.example.marketplace.entity.Rating
import com.example.marketplace.exception.NotFoundException
import com.example.marketplace.repository.BuyerRepository
import com.example.marketplace.repository.RatingRepository
import org.springframework.stereotype.Service

@Service
class RatingService(
    val ratingRepository: RatingRepository,
    val buyerRepository: BuyerRepository,
    val saleService: SaleService,
    val productService: ProductService
) {

    fun rateProduct(ratingDTO: RatingDTO): Rating {
        val product = productService.findById(ratingDTO.productId)
        val buyer = buyerRepository.findByUserId(ratingDTO.userId)

        if ((product.id != null) && (buyer.id != null)) {
            val sale = saleService.findByProductAndClient(product.id, buyer.id)

            if (sale == null) {
                throw (NotFoundException("Buyer or Product not found!"))
            } else {
                return ratingRepository.save(
                    Rating(
                        rate = ratingDTO.rate,
                        sale = sale,
                    )
                )
            }
        } else {
            throw (NotFoundException("Buyer or Product not found!"))
        }

    }

    fun findAll(): List<Rating> =
        ratingRepository.findAll()

    fun findById(id: String): Rating =
        ratingRepository.findById(id)
            .orElseThrow { NotFoundException("Rating with id $id not found") }

    fun deleteById(id: String) {
        val rating = findById(id)
        ratingRepository.delete(rating)
    }
}