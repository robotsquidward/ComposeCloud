package com.ajkueterman.composecloud.ui.model

import androidx.annotation.IdRes
import com.ajkueterman.composecloud.R

sealed class ScreenState(
    val headerItems: HeaderItems
) {
    object Files: ScreenState(
        headerItems = HeaderItems(
            start = R.drawable.ic_baseline_menu_24,
            end = R.drawable.profile_image
        )
    )
    object Storage: ScreenState(
        headerItems = HeaderItems(
            start = R.drawable.ic_baseline_arrow_back_24,
            end = R.drawable.ic_baseline_more_vert_24
        )
    )
}

data class HeaderItems(
    val start: Int,
    val end: Int
)