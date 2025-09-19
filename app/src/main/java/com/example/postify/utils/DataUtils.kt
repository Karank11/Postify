package com.example.postify.utils

import com.example.postify.R
import com.example.postify.models.Category

object DataUtils {
    val productCategories = listOf(
        Category("Electronics", R.drawable.electronics),
        Category("Clothing",R.drawable.fashion),
        Category("Books",R.drawable.education),
        Category("Home & Kitchen",R.drawable.appliances),
        Category("Sports",R.drawable.sports),
        Category("Beauty",R.drawable.beauty)
    )

    val postCategories = listOf(
        Category("Technology", R.drawable.technology),
        Category("Sports",R.drawable.sports),
        Category("Food & Cooking",R.drawable.cooking),
        Category("Travel",R.drawable.travel),
        Category("Health & Fitness",R.drawable.health),
        Category("Entertainment",R.drawable.entertainment),
        Category("Education",R.drawable.education),
        Category("Business",R.drawable.business)
    )

    fun getJsonPath(type: String, category: String): String {
        return "$type[?(@.category=='$category')]"
    }
}