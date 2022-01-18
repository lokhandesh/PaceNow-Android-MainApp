package com.android.pacenow.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CountryResponse(
    val data: String
) : Parcelable
