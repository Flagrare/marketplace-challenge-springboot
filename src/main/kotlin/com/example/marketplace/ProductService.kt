package com.example.marketplace

import com.example.marketplace.data.Product
import com.example.marketplace.data.ProductRepository
import com.example.marketplace.dto.ProductDTO
import com.example.marketplace.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class ProductService(val productRepository: ProductRepository) {

    fun findAll(): List<Product> =
        productRepository.findAll()

    fun findById(id: String): Product =
        productRepository.findById(id)
            .orElseThrow { NotFoundException("Product with id $id not found") }

    fun createProduct(productDTO: ProductDTO): Product =
        productRepository.save(
            Product(
                name = productDTO.name,
                desc = productDTO.desc
            )
        )

    fun updateProduct(id: String, productDTO: ProductDTO): Product {
        val productToUpdate = findById(id)

        return productRepository.save(
            productToUpdate.apply {
                name = productDTO.name
                desc = productDTO.desc
            }
        )
    }


    fun deleteById(id: String) {
        val product = findById(id)

        productRepository.delete(product)
    }
}