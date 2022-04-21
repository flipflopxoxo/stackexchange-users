package com.clydelizardo.stackexchangeusers.api.model

import com.google.gson.annotations.SerializedName

data class Collective(
    @SerializedName("external_links")
    val externalLinks: List<ExternalLink>?,
    @SerializedName("link")
    val link: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("tags")
    val tags: List<String>?,
)