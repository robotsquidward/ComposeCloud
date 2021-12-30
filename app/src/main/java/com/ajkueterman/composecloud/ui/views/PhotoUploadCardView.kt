package com.ajkueterman.composecloud.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ajkueterman.composecloud.R
import com.ajkueterman.composecloud.ui.theme.*
import com.ajkueterman.composecloud.ui.util.drawColoredShadow

@Composable
fun PhotoUploadCardView(
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.cardSurface,
        shape = RoundedCornerShape(32.dp),
        modifier = modifier
            .drawColoredShadow(
                color = Color.LightGray,
                borderRadius = 32.dp,
                offsetY = 4.dp,
                shadowRadius = 30.dp,
            )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Photo Upload",
                        fontWeight = FontWeight.Medium,
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.textOnSurface
                    )
                    Text(
                        text = "Cloud > Photos > Nature",
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.textOnSearchSurface
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = "Favorites context menu.",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(24.dp)
                )
            }
            TwoPhotoLayout()
        }
    }
}

@Composable
fun TwoPhotoLayout() {
    Row(
        modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Photo 1",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Photo 1",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
        )
    }
}

@Preview
@Composable
fun PhotoUploadCardViewPreview() {
    ComposeCloudTheme {
        Box(
            modifier = Modifier.background(MaterialTheme.colors.themedSurface)
        ) {
            PhotoUploadCardView()
        }
    }
}