package com.example.marketplace.controller

import com.example.marketplace.ProductService
import com.example.marketplace.data.Product
import com.example.marketplace.data.ProductResponseObject
import com.example.marketplace.dto.ProductDTO
import com.example.marketplace.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger

@RestController
@RequestMapping("products")
internal class ProductController(val productService: ProductService) {

    val logger: Logger = Logger.getLogger(ProductController::class.java.canonicalName)

    @PostMapping
    fun createProduct(@RequestBody productDTO: ProductDTO): ResponseEntity<ProductResponseObject> {
        val createdProduct = productService.createProduct(productDTO)
        logger.info("product created $createdProduct")
        return ResponseEntity
            .ok(
                ProductResponseObject.fromEntity(createdProduct)
            )
    }

    @GetMapping
    fun getAllProduct(): ResponseEntity<List<ProductResponseObject>> {
        val products = productService.findAll()
        return ResponseEntity
            .ok(
                products.map { ProductResponseObject.fromEntity(it) }
            )
    }

    @GetMapping("/{id}")
    fun getProductDetail(@PathVariable("id") id: String): ResponseEntity<ProductResponseObject> {

        val product = productService.findById(id)
        logger.info("product $product")

        return ResponseEntity.ok(ProductResponseObject.fromEntity(product))

    }

    @PutMapping("/{id}")
    fun updateProduct(
        @PathVariable id: String,
        @RequestBody request: ProductDTO
    ): ResponseEntity<ProductResponseObject> {
        val updatedCompany = productService.updateProduct(id, request)

        return ResponseEntity
            .ok(
                ProductResponseObject.fromEntity(updatedCompany)
            )
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: String): ResponseEntity<Void> {
        productService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}