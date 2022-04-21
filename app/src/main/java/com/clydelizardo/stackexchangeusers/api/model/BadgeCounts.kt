package com.clydelizardo.stackexchangeusers.api.model

import com.google.gson.annotations.SerializedName

data class BadgeCounts(
    @SerializedName("gold")
    val gold: Int = 0,
    @SerializedName("silver")
    val silver: Int = 0,
    @SerializedName("bronze")
    val bronze: Int = 0,
)