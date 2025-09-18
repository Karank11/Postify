package com.example.postify.network

import com.example.postify.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.jsonbin.io/v3/b/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain->
            val request = chain.request().newBuilder()
                .addHeader("X-Master-Key", BuildConfig.BIN_MASTER_KEY)
                .build()

            chain.proceed(request)
        }
        .build()

    val postifyApiService: PostifyApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(PostifyApiService::class.java)
    }
}