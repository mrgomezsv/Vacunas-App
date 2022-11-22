package com.buffetapp.covidapp

import androidx.annotation.DrawableRes

data class News(
    val id:Long,
    @DrawableRes
    val image:Int?,
    val title:String,
    val resumen:String
)