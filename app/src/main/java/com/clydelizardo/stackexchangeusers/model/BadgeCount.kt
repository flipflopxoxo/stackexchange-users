package com.clydelizardo.stackexchangeusers.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BadgeCount(
    val bronze: Int,
    val silver: Int,
    val gold: Int
): Parcelable