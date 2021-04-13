package com.example.marketplace.data

import com.example.marketplace.entity.Category

class CategoryVO(
    val id: String,
    val name: String,
    val desc: String,
) {
    companion object {
        fun fromEntity(category: Category): CategoryVO =
            CategoryVO(
                id = category.id!!,
                name = category.name,
                desc = category.desc!!,
            )
    }
}

