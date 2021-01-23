package com.laurentva.gamestore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(var name: String, var platform: String, var company: String, var description: String,
                val image: Int) : Parcelable