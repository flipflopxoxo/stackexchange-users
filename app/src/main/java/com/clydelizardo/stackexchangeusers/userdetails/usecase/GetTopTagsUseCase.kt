package com.clydelizardo.stackexchangeusers.userdetails.usecase

import com.clydelizardo.stackexchangeusers.model.User
import com.clydelizardo.stackexchangeusers.model.UserTagInfo

fun interface GetTopTagsUseCase {
    suspend operator fun invoke(user: User): List<UserTagInfo>
}