package com.example.postify.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postify.models.Product
import com.example.postify.repository.PostifyRepository
import com.example.postify.utils.DataUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(val postifyRepository: PostifyRepository): ViewModel() {
    val categories = listOf("Electronics", "Clothing", "Books", "Home & Kitchen", "Sports", "Beauty")
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> get() = _products

    init {
        fetchProductsForCategory("Clothing")
    }

    fun fetchProductsForCategory(category: String) {
        viewModelScope.launch {
            try {
                val list = postifyRepository.getProductsForCategory(DataUtils.getJsonPath("products", category))
                _products.emit(list)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}