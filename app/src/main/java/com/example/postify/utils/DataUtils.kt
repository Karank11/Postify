package com.example.postify.utils

import com.example.postify.models.Item
import com.example.postify.models.Post
import com.example.postify.models.Product

object DataUtils {
    fun getJsonPath(type: String, category: String): String {
        return "$type[?(@.category=='$category')]"
    }

    fun convertProductsToItems(products: List<Product>): List<Item> {
        val items = mutableListOf<Item>()
        for (product in products) {
            items.add(
                Item(
                    imageUrl = product.imageUrl,
                    title = product.title,
                    description = product.description
                )
            )
        }
        return items
    }

    fun convertPostsToItems(posts: List<Post>): List<Item> {
        val items = mutableListOf<Item>()
        for (post in posts) {
            items.add(
                Item(
                    imageUrl = post.imageUrl,
                    title = post.title,
                    description = post.description
                )
            )
        }
        return items
    }
}