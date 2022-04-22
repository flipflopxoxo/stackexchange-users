package com.clydelizardo.stackexchangeusers.userdetails.usecase

import com.clydelizardo.stackexchangeusers.model.User
import com.clydelizardo.stackexchangeusers.model.UserTagInfo

fun interface GetTopTagsForUserUseCase {
    suspend operator fun invoke(user: User): List<UserTagInfo>
}