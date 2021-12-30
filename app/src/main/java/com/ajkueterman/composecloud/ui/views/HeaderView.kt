package com.ajkueterman.composecloud.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ajkueterman.composecloud.ui.model.ScreenState
import com.ajkueterman.composecloud.ui.theme.ComposeCloudTheme
import com.ajkueterman.composecloud.ui.theme.textOnSurface
import com.ajkueterman.composecloud.ui.theme.themedSurface

@Composable
fun HeaderView(
    state: ScreenState,
    menuClicked: () -> Unit,
    profileClicked: () -> Unit,
) {
    Column {
        AppBar(state, menuClicked, profileClicked)
        Text(
            text = when (state) {
                ScreenState.Storage -> "Storage"
                ScreenState.Files -> "Files"
            },
            color = MaterialTheme.colors.textOnSurface,
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.size(8.dp))
    }
}

@Composable
fun AppBar(
    state: ScreenState,
    menuClicked: () -> Unit,
    profileClicked: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        IconButton(onClick = menuClicked) {
            Image(
                painter = painterResource(id = state.headerItems.start),
                contentDescription = "Open main menu button.",
                colorFilter = ColorFilter.tint(MaterialTheme.colors.textOnSurface),
                modifier = Modifier.size(32.dp)
            )
        }
        IconButton(
            onClick = profileClicked,
            modifier = Modifier.padding(end = if (state == ScreenState.Files) 8.dp else 0.dp)
        ) {
            Image(
                painter = painterResource(id = state.headerItems.end),
                contentDescription = "Open user profile button.",
                colorFilter = if (state == ScreenState.Storage) ColorFilter.tint(MaterialTheme.colors.textOnSurface) else null,
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
            )
        }
    }
}

@Preview
@Composable
fun HeaderViewPreviewFiles() {
    ComposeCloudTheme {
        Box(
            modifier = Modifier.background(MaterialTheme.colors.themedSurface)
        ){
            HeaderView(
                state = ScreenState.Files,
                menuClicked = {},
                profileClicked = {},
            )
        }
    }
}

@Preview
@Composable
fun HeaderViewPreviewStorage() {
    ComposeCloudTheme {
        Box(
            modifier = Modifier.background(MaterialTheme.colors.themedSurface)
        ){
            HeaderView(
                state = ScreenState.Storage,
                menuClicked = {},
                profileClicked = {},
            )
        }
    }
}