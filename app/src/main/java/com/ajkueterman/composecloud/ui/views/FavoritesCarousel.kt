package com.ajkueterman.composecloud.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ajkueterman.composecloud.R
import com.ajkueterman.composecloud.ui.theme.*
import com.ajkueterman.composecloud.ui.util.drawColoredShadow

@Composable
fun FavoritesCarouselView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Favorites",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colors.textOnSurface,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 8.dp)
        )
        LazyRow {
            item {
                Spacer(modifier = Modifier.width(16.dp))
            }
            item {
                FavoriteCardView(
                    modifier = Modifier.padding(8.dp),
                    contextMenuTapped = {},
                )
            }
            item {
                FavoriteCardView(
                    modifier = Modifier.padding(8.dp),
                    contextMenuTapped = {},
                )
            }
            item {
                FavoriteCardView(
                    modifier = Modifier.padding(8.dp),
                    contextMenuTapped = {},
                )
            }
            item {
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}

@Composable
fun FavoriteCardView(
    contextMenuTapped: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.cardSurface,
        shape = RoundedCornerShape(32.dp),
        modifier = modifier
            .width(200.dp)
            .height(200.dp)
            .drawColoredShadow(
                color = Color.LightGray,
                borderRadius = 32.dp,
                offsetY = 4.dp,
                shadowRadius = 30.dp,
            )
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = "Favorites context menu.",
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .size(44.dp)
                )
                IconButton(onClick = contextMenuTapped) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
                        contentDescription = "Favorites context menu.",
                        tint = MaterialTheme.colors.textOnSearchSurface,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 8.dp)
            ) {
                Text(
                    text = "Favorite Name",
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.textOnSurface
                )
                Text(
                    text = "Favorites stats: 1GB",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.textOnSearchSurface
                )
                Image(
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = "Favorites context menu.",
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .clip(CircleShape)
                        .size(24.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun FavoritesCarouselViewPreview() {
    ComposeCloudTheme {
        Box(
            modifier = Modifier.background(MaterialTheme.colors.themedSurface)
        ) {
            FavoritesCarouselView()
        }
    }
}