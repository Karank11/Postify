package com.example.postify.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postify.models.Item
import com.example.postify.repository.PostifyRepository
import com.example.postify.utils.DataUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    val postifyRepository: PostifyRepository,
    val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> get() = _items

    init {
        fetchDetailScreen()
    }

    fun fetchDetailScreen() {
        val type = savedStateHandle.get<String>("type") ?: "posts"
        val category = savedStateHandle.get<String>("category") ?: "Technology"
        val jsonPath = DataUtils.getJsonPath(type, category)
        viewModelScope.launch {
            try {
                if (type == "posts") {
                    val list = postifyRepository.getPostsForCategory(jsonPath)
                    _items.emit(DataUtils.convertPostsToItems(list))
                } else {
                    val list = postifyRepository.getProductsForCategory(jsonPath)
                    _items.emit(DataUtils.convertProductsToItems(list))
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}