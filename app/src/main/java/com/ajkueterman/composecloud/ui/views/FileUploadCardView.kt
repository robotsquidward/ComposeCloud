package com.ajkueterman.composecloud.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ajkueterman.composecloud.ui.theme.ComposeCloudTheme
import com.ajkueterman.composecloud.ui.theme.cardSurface
import com.ajkueterman.composecloud.ui.theme.themedSurface
import com.ajkueterman.composecloud.ui.util.drawColoredShadow

@Composable
fun FileUploadCardView(
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
        Text("File Upload")
    }
}

@Preview
@Composable
fun FileUploadCardViewPreview() {
    ComposeCloudTheme {
        Box(
            modifier = Modifier.background(MaterialTheme.colors.themedSurface)
        ) {
            FileUploadCardView()
        }
    }
}