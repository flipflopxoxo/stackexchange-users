package com.clydelizardo.stackexchangeusers.model

import kotlinx.parcelize.Parcelize

data class BadgeCount(
    val bronze: Int,
    val silver: Int,
    val gold: Int
)