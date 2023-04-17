package com.example.plant30days.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Exercise(
    @StringRes val dayRes: Int,
    @StringRes val namRes: Int,
    @DrawableRes val desImage: Int,
    @StringRes val insRes: Int,
    @StringRes val timeRes: Int
)
