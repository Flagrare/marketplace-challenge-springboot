package com.example.marketplace.controller

import com.example.marketplace.data.CategoryVO
import com.example.marketplace.dto.CategoryDTO
import com.example.marketplace.service.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger

@RestController
@RequestMapping("category")
internal class CategoryController(val categoryService: CategoryService) {

    val logger: Logger = Logger.getLogger(CategoryController::class.java.canonicalName)

    @PostMapping
    fun createCategory(@RequestBody categoryDTO: CategoryDTO): ResponseEntity<CategoryVO> {
        val createdCategory = categoryService.createCategory(categoryDTO)
        logger.info("Category created $createdCategory")
        return ResponseEntity
            .ok(
                CategoryVO.fromEntity(createdCategory)
            )
    }

    @GetMapping
    fun getAllCategories(): ResponseEntity<List<CategoryVO>> {
        val categories = categoryService.findAll()
        return ResponseEntity
            .ok(
                categories.map { CategoryVO.fromEntity(it) }
            )
    }

    @GetMapping("/{id}")
    fun getCategoryDetail(@PathVariable("id") id: String): ResponseEntity<CategoryVO> {

        val category = categoryService.findById(id)
        logger.info("Category $category")

        return ResponseEntity.ok(CategoryVO.fromEntity(category))

    }

    @PutMapping("/{id}")
    fun updateCategory(
        @PathVariable id: String,
        @RequestBody request: CategoryDTO
    ): ResponseEntity<CategoryVO> {
        val updatedCategory = categoryService.updateCategory(id, request)

        return ResponseEntity
            .ok(
                CategoryVO.fromEntity(updatedCategory)
            )
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: String): ResponseEntity<Void> {
        categoryService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}