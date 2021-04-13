package com.example.marketplace.controller

import com.example.marketplace.data.CategoryVO
import com.example.marketplace.dto.CategoryDTO
import com.example.marketplace.dto.SaleDTO
import com.example.marketplace.entity.Sale
import com.example.marketplace.service.SaleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger

@RestController
@RequestMapping("sale")
internal class SaleController(val saleService: SaleService) {

    val logger: Logger = Logger.getLogger(SaleController::class.java.canonicalName)

    @PostMapping
    fun purchaseProduct(@RequestBody saleDTO: SaleDTO): ResponseEntity<Sale> {
        val sale = saleService.purchaseProduct(saleDTO)
        logger.info("Product purchased $sale")
        return ResponseEntity
            .ok(
                sale
            )
    }

    @GetMapping
    fun getAllPurchases(): ResponseEntity<List<Sale>> {
        val sales = saleService.findAll()
        return ResponseEntity
            .ok(
                sales.map { it }
            )
    }

    @GetMapping("/{id}")
    fun getCategoryDetail(@PathVariable("id") id: String): ResponseEntity<Sale> {

        val sale = saleService.findById(id)
        logger.info("Sale $sale")

        return ResponseEntity.ok(sale)

    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: String): ResponseEntity<Void> {
        saleService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}