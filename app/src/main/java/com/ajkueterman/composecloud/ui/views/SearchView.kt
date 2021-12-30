package com.ajkueterman.composecloud.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ajkueterman.composecloud.R
import com.ajkueterman.composecloud.ui.theme.ComposeCloudTheme
import com.ajkueterman.composecloud.ui.theme.searchViewSurface
import com.ajkueterman.composecloud.ui.theme.textOnSearchSurface
import com.ajkueterman.composecloud.ui.theme.themedSurface

@Composable
fun SearchView() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(100))
            .background(MaterialTheme.colors.searchViewSurface)
            .padding(horizontal = 16.dp)
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = "Search",
            color = MaterialTheme.colors.textOnSearchSurface
        )
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_search_24),
            contentDescription = "Search icon",
            colorFilter = ColorFilter.tint(MaterialTheme.colors.textOnSearchSurface)
        )
    }
}

@Preview
@Composable
fun SearchViewPreview() {
    ComposeCloudTheme {
        Box(
            modifier = Modifier.background(MaterialTheme.colors.themedSurface)
        ) {
            SearchView()
        }
    }
}