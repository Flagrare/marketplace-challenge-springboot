package com.example.marketplace.data

class ProductResponseObject(
    val id:String,
    val name: String,
    val desc: String
) {
    companion object{
        fun fromEntity(product: Product):ProductResponseObject=
            ProductResponseObject(
                id = product.id!!,
                name = product.name,
                desc = product.desc
            )
    }
}

