package com.example.marketplace.service

import com.example.marketplace.dto.BuyerDTO
import com.example.marketplace.entity.Buyer
import com.example.marketplace.entity.User
import com.example.marketplace.exception.NotFoundException
import com.example.marketplace.repository.BuyerRepository
import org.springframework.stereotype.Service

@Service
class BuyerService(val buyerRepository: BuyerRepository) {

    fun findById(id: String): Buyer =
        buyerRepository.findById(id)
            .orElseThrow { NotFoundException("Buyer with id $id not found") }

    fun findByUserId(userId: String): Buyer =
        buyerRepository.findByUserId(userId)

    fun createBuyer(user: User): Buyer =
        buyerRepository.save(
            Buyer(
                user = user
            )
        )

    fun updateBuyer(id: String, buyerDTO: BuyerDTO): Buyer {
        val buyerToUpdate = findById(id)

        return buyerRepository.save(
            buyerToUpdate.apply {
                user.name = buyerDTO.user.name
            }
        )
    }


    fun deleteById(id: String) {
        val buyer = findById(id)
        buyerRepository.delete(buyer)
    }
}