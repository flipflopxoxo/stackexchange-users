package com.clydelizardo.stackexchangeusers.model

import java.util.*

data class User(
    val id: Int,
    val name: String,
    val reputation: Int,
    val topTags: List<String>,
    val location: String?,
    val creationDate: Date,
    val profileImageUrl: String
)