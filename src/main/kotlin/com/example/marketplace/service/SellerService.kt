package com.example.marketplace.service

import com.example.marketplace.dto.SellerDTO
import com.example.marketplace.entity.Buyer
import com.example.marketplace.entity.Seller
import com.example.marketplace.entity.User
import com.example.marketplace.exception.NotFoundException
import com.example.marketplace.repository.SellerRepository
import org.springframework.stereotype.Service

@Service
class SellerService(val sellerRepository: SellerRepository) {

    fun findById(id: String): Seller =
        sellerRepository.findById(id)
            .orElseThrow { NotFoundException("Seller with id $id not found") }

    fun findByUserId(userId: String): Seller =
        sellerRepository.findByUserId(userId)

    fun createSeller(user: User): Seller =
        sellerRepository.save(
            Seller(
                user = user
            )
        )

    fun updateSeller(id: String, sellerDTO: SellerDTO): Seller {
        val sellerToUpdate = findById(id)

        return sellerRepository.save(
            sellerToUpdate.apply {
                user.name = sellerDTO.user.name
            }
        )
    }


    fun deleteById(id: String) {
        val seller = findById(id)

        sellerRepository.delete(seller)
    }
}