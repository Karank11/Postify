package com.example.postify.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.postify.models.Item

@Composable
fun DetailScreen(items: List<Item>) {
    LazyColumn {
        items(items.size) {
            Item(items[it])
        }
    }
}

@Composable
fun Item(item: Item) {
    Card(modifier = Modifier.padding(8.dp)) {
        Row(modifier = Modifier.height(150.dp)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(150.dp)
            )
            Spacer(
                modifier = Modifier.size(8.dp)
            )
            Column {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(0.dp, 8.dp)
                )
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxHeight(1f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    DetailScreen(
        listOf(
            Item(
                imageUrl = "https://picsum.photos/seed/44/150/150",
                title = "Item Title",
                description = "This is the description for the current Item of the category."
            ),
            Item(
                imageUrl = "https://picsum.photos/seed/44/400/300",
                title = "Item Title",
                description = "This is the description for the current Item of the category."
            ),
            Item(
                imageUrl = "https://picsum.photos/seed/44/400/300",
                title = "Item Title",
                description = "This is the description for the current Item of the category."
            ),
            Item(
                imageUrl = "https://picsum.photos/seed/44/400/300",
                title = "Item Title",
                description = "This is the description for the current Item of the category."
            ),
            Item(
                imageUrl = "https://picsum.photos/seed/44/400/300",
                title = "Item Title",
                description = "This is the description for the current Item of the category."
            ),
            Item(
                imageUrl = "https://picsum.photos/seed/44/400/300",
                title = "Item Title",
                description = "This is the description for the current Item of the category."
            ),
            Item(
                imageUrl = "https://picsum.photos/seed/44/400/300",
                title = "Item Title",
                description = "This is the description for the current Item of the category."
            )
        )
    )
}