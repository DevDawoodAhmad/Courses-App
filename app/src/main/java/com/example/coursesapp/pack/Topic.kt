package com.example.coursesapp.pack

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
   @DrawableRes val imageId : Int,
   val marks : Int,
   @StringRes val stringId : Int

)
