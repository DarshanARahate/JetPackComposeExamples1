package com.compose.example.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.example.R

@Preview
@Composable
fun ShowBlog() {
    LazyColumn {
        items(getCategoryList()) { item ->
            BlogCategory(
                img = item.img,
                title = item.title,
                subtitle = item.subTitle
            )
        }
    }
}

@Composable
fun BlogCategory(img: Int, title: String, subtitle: String) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(0.2f)
            )
            ItemDescription(title, subtitle, modifier = Modifier.weight(0.8f))
        }
    }
}

@Composable
private fun ItemDescription(title: String, subtitle: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Thin
        )
    }
}

data class Category(val img: Int, val title: String, val subTitle: String)

fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()

    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 1",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 2",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 3",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 4",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 5",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 6",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 7",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 8",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 9",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 10",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 11",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 12",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 13",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 14",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 15",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 16",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 17",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 18",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 19",
            "Learn Different Languages"
        )
    )
    list.add(
        Category(
            R.drawable.ic_launcher_background,
            "Programming 20",
            "Learn Different Languages"
        )
    )

    return list
}
