package com.example.postify.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.postify.models.Category
import com.example.postify.utils.DataUtils

@Composable
fun CategoryScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .padding(8.dp, 40.dp, 8.dp, 8.dp)
    ) {
        ProductCategorySection()
        PostCategorySection()
    }
}


@Composable
fun ProductCategorySection() {
    Column {
        Text(
            text = "Product Category",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(0.dp,0.dp, 0.dp, 8.dp)
        )
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            modifier = Modifier
                .height(260.dp)
        ) {
            items(DataUtils.productCategories.size) { index->
                CategoryItem(DataUtils.productCategories[index])
            }
        }
        Spacer(
            modifier = Modifier.height(8.dp)
        )
    }
}

@Composable
fun PostCategorySection() {
    Column {
        Text(
            text = "Posts Category",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(0.dp,16.dp, 0.dp, 8.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
        ) {
            items(DataUtils.postCategories.size) { index->
                CategoryItem(DataUtils.postCategories[index])
            }
        }
    }
}


@Composable
fun CategoryItem(category: Category) {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .width(110.dp)
            .height(120.dp)
            .border(0.1.dp, Color.Black, RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(category.drawable),
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = Modifier
                .width(110.dp)
                .height(100.dp)
                .padding(8.dp)

        )
        Text(
            text = category.title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .height(30.dp)
                .fillMaxWidth(1f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCategoryScreen() {
    CategoryScreen()
}