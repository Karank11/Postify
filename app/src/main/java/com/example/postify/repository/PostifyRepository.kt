package com.example.postify.repository

import com.example.postify.api.PostifyApiService
import com.example.postify.models.Post
import com.example.postify.models.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostifyRepository @Inject constructor(val postifyApiService: PostifyApiService) {

    suspend fun getProductsForCategory(jsonPath: String): List<Product> {
        return withContext(Dispatchers.IO) {
            postifyApiService.getProductsWithCategory(jsonPath)
        }
    }

    suspend fun getPostsForCategory(jsonPath: String): List<Post> {
        return withContext(Dispatchers.IO) {
            postifyApiService.getPostsWithCategory(jsonPath)
        }
    }
}