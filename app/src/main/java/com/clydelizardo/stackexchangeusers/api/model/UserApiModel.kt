package com.clydelizardo.stackexchangeusers.api.model

import com.google.gson.annotations.SerializedName

data class UserApiModel(
    @SerializedName("reputation_change_quarter")
    val reputationChangeQuarter: Int = 0,
    @SerializedName("collectives")
    val collectives: List<CollectiveMembership>?,
    @SerializedName("link")
    val link: String = "",
    @SerializedName("last_modified_date")
    val lastModifiedDate: Int? = null,
    @SerializedName("last_access_date")
    val lastAccessDate: Int = 0,
    @SerializedName("reputation")
    val reputation: Int = 0,
    @SerializedName("badge_counts")
    val badgeCounts: BadgeCounts,
    @SerializedName("creation_date")
    val creationDate: Int = 0,
    @SerializedName("display_name")
    val displayName: String = "",
    @SerializedName("reputation_change_year")
    val reputationChangeYear: Int = 0,
    @SerializedName("accept_rate")
    val acceptRate: Int? = null,
    @SerializedName("is_employee")
    val isEmployee: Boolean = false,
    @SerializedName("profile_image")
    val profileImage: String = "",
    @SerializedName("account_id")
    val accountId: Int = 0,
    @SerializedName("user_type")
    val userType: String = "",
    @SerializedName("website_url")
    val websiteUrl: String = "",
    @SerializedName("reputation_change_week")
    val reputationChangeWeek: Int = 0,
    @SerializedName("user_id")
    val userId: Int = 0,
    @SerializedName("reputation_change_day")
    val reputationChangeDay: Int = 0,
    @SerializedName("location")
    val location: String? = null,
    @SerializedName("reputation_change_month")
    val reputationChangeMonth: Int = 0,
)