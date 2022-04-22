package com.clydelizardo.stackexchangeusers.api.model.toptags

import com.google.gson.annotations.SerializedName

data class UserTagInfo(@SerializedName("question_count")
                       val questionCount: Int = 0,
                       @SerializedName("user_id")
                       val userId: Int = 0,
                       @SerializedName("tag_name")
                       val tagName: String = "",
                       @SerializedName("question_score")
                       val questionScore: Int = 0,
                       @SerializedName("answer_count")
                       val answerCount: Int = 0,
                       @SerializedName("answer_score")
                       val answerScore: Int = 0)