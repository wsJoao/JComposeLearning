package com.jppin.composelearning.ui.navigation.content
import androidx.annotation.DrawableRes

data class BottomMenuContent(
    val title: String,
    @DrawableRes val iconId: Int,
    val route: String
)

