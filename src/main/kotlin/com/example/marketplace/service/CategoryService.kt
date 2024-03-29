package com.example.marketplace.service

import com.example.marketplace.dto.CategoryDTO
import com.example.marketplace.entity.Category
import com.example.marketplace.exception.NotFoundException
import com.example.marketplace.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(val categoryRepository: CategoryRepository) {

    fun findAll(): List<Category> =
        categoryRepository.findAll()

    fun findById(id: String): Category =
        categoryRepository.findById(id)
            .orElseThrow { NotFoundException("Category with id $id not found") }


    fun findByName(name: String): Category =
        categoryRepository.findByName(name)

    fun createCategory(category: CategoryDTO): Category =
        categoryRepository.save(
            Category(
                name = category.name,
                desc = category.desc,
            )
        )

    fun updateCategory(id: String, categoryDTO: CategoryDTO): Category {
        val categoryToUpdate = findById(id)

        return categoryRepository.save(
            categoryToUpdate.apply {
                name = categoryDTO.name
                desc = categoryDTO.desc
            }
        )
    }


    fun deleteById(id: String) {
        val category = findById(id)

        categoryRepository.delete(category)
    }
}