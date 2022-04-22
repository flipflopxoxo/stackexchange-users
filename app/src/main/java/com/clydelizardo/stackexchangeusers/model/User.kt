package com.clydelizardo.stackexchangeusers.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class User(
    val id: Int,
    val name: String,
    val reputation: Int,
    val location: String?,
    val creationDate: Date,
    val profileImageUrl: String,
    val badgeCount: BadgeCount
): Parcelable