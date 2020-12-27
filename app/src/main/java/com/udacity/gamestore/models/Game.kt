package com.udacity.gamestore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(var name: String, var platform: String, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable