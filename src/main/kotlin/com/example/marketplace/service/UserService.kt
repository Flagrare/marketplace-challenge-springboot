package com.example.marketplace.service

import com.example.marketplace.dto.UserDTO
import com.example.marketplace.entity.User
import com.example.marketplace.exception.NotFoundException
import com.example.marketplace.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {

    fun findById(id: String): User =
        userRepository.findById(id)
            .orElseThrow { NotFoundException("User with id $id not found") }

    fun createSeller(userDTO: UserDTO): User =
        userRepository.save(
            User(
                name = userDTO.name,
            )
        )

    fun updateSeller(id: String, userDTO: UserDTO): User {
        val UserToUpdate = findById(id)

        return userRepository.save(
            UserToUpdate.apply {
                name = userDTO.name
            }
        )
    }


    fun deleteById(id: String) {
        val user = findById(id)

        userRepository.delete(user)
    }
}