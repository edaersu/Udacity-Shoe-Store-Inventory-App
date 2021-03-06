package com.example.shoestore.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShoeModel(
    var name: String, var size: String, var company: String, var description: String,
    val images: List<Int> = mutableListOf()
) : Parcelable