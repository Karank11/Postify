package com.example.postify.utils

object DataUtils {
    fun getJsonPath(type: String, category: String): String {
        return "$type[?(@.category=='$category')]"
    }
}