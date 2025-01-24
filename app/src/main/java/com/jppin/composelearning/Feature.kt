package com.jppin.composelearning

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Feature(
    val title: String,
    @DrawableRes val iconId: Int,
    @DrawableRes val imageId: Int,
    val lightColor: Color,
)
