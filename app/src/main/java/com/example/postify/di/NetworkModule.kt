package com.example.postify.di

import com.example.postify.BuildConfig
import com.example.postify.api.PostifyApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain->
                val request = chain.request().newBuilder()
                    .addHeader("X-Master-Key", BuildConfig.BIN_MASTER_KEY)
                    .build()
                chain.proceed(request)
            }
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providePostifyApiService(): PostifyApiService {
        return provideRetrofit(provideOkHttpClient()).create(PostifyApiService::class.java)
    }
}