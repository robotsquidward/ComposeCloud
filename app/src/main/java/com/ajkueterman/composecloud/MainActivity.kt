package com.ajkueterman.composecloud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ajkueterman.composecloud.ui.model.ScreenState
import com.ajkueterman.composecloud.ui.theme.ComposeCloudTheme
import com.ajkueterman.composecloud.ui.theme.themedSurface
import com.ajkueterman.composecloud.ui.views.FavoritesCarouselView
import com.ajkueterman.composecloud.ui.views.HeaderView
import com.ajkueterman.composecloud.ui.views.SearchView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCloudTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.themedSurface
    ) {
        Column {
            HeaderView(
                state = ScreenState.Files,
                menuClicked = {},
                profileClicked = {}
            )
            LazyColumn {
                item { SearchView() }
                item {
                    FavoritesCarouselView(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .padding(bottom = 16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCloudTheme {
        App()
    }
}