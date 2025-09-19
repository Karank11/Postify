package com.example.postify.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postify.models.Post
import com.example.postify.repository.PostifyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(val postifyRepository: PostifyRepository): ViewModel() {
    val categories = listOf("Technology", "Food & Cooking", "Travel", "Home & Kitchen", "Sports", "Health & Fitness", "Entertainment", "Education", "Business")
    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> get() = _posts

    fun fetchPostsForCategory(category: String) {
        viewModelScope.launch {
            try {
                val list = postifyRepository.getPostsForCategory(category)
                _posts.emit(list)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}