package com.example.postify.network

import com.example.postify.models.Post
import com.example.postify.models.Product
import retrofit2.http.GET
import retrofit2.http.Query

interface PostifyApiService {

    @GET("68cc17b0d0ea881f40823111")
    suspend fun getProducts(@Query("meta") meta: Boolean = false): List<Product>

    @GET("68cc188fd0ea881f408231dd")
    suspend fun getPosts(@Query("meta") meta: Boolean = false): List<Post>
}
