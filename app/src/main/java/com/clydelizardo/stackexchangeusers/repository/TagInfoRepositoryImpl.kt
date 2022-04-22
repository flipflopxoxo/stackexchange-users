package com.clydelizardo.stackexchangeusers.repository

import com.clydelizardo.stackexchangeusers.api.UserService
import com.clydelizardo.stackexchangeusers.model.User
import com.clydelizardo.stackexchangeusers.model.UserTagInfo
import javax.inject.Inject

class TagInfoRepositoryImpl @Inject constructor(
    private val userService: UserService,
) : TagInfoRepository {
    override suspend fun getTagsForUser(user: User): List<UserTagInfo> {
        return userService.getTopTags(userId = user.id, site = "stackoverflow").items?.map {
            UserTagInfo(
                tagName = it.tagName,
                postsCount = it.questionCount + it.answerCount
            )
        } ?: emptyList()
    }
}