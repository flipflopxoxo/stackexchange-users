package com.clydelizardo.stackexchangeusers.api.model

import com.google.gson.annotations.SerializedName

data class CollectiveMembership(
    @SerializedName("role")
    val role: String = "",
    @SerializedName("collective")
    val collective: Collective,
)