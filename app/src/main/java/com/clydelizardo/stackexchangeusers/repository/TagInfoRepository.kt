package com.clydelizardo.stackexchangeusers.repository

import com.clydelizardo.stackexchangeusers.model.User
import com.clydelizardo.stackexchangeusers.model.UserTagInfo

interface TagInfoRepository {
    suspend fun getTagsForUser(user: User): List<UserTagInfo>
}