package com.example.postify.network

import com.example.postify.models.Post
import com.example.postify.models.Product
import retrofit2.http.GET
import retrofit2.http.Header

interface PostifyApiService {

    @GET("v3/b/68cc17b0d0ea881f40823111?meta=false")
    suspend fun getProductsWithCategory(@Header("X-JSON-Path") jsonPath: String): List<Product>

    @GET("v3/b/68cc188fd0ea881f408231dd?meta=false")
    suspend fun getPostsWithCategory(@Header("X-JSON-Path") jsonPath: String): List<Post>
}
