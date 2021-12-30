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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ajkueterman.composecloud.ui.model.FABElevation
import com.ajkueterman.composecloud.ui.model.ScreenState
import com.ajkueterman.composecloud.ui.theme.ComposeCloudTheme
import com.ajkueterman.composecloud.ui.theme.textOnSurface
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
        color = MaterialTheme.colors.themedSurface,
    ) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    backgroundColor = MaterialTheme.colors.primary,
                    elevation = FABElevation(
                        pressedElevation = 6.dp,
                        defaultElevation = 24.dp
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_add_24),
                        contentDescription = "Add new file floating action button.",
                        tint = MaterialTheme.colors.onPrimary,
                    )
                }
            }
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
                    item {
                        Text(
                            text = "Recent Uploads",
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colors.textOnSurface,
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .padding(bottom = 8.dp)
                        )
                    }
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