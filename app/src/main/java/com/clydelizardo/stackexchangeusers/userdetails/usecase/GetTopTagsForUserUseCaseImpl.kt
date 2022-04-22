package com.clydelizardo.stackexchangeusers.userdetails.usecase

import com.clydelizardo.stackexchangeusers.model.User
import com.clydelizardo.stackexchangeusers.model.UserTagInfo
import com.clydelizardo.stackexchangeusers.repository.TagInfoRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GetTopTagsForUserUseCaseImpl @Inject constructor(
    private val tagInfoRepository: TagInfoRepository
) : GetTopTagsForUserUseCase {
    override suspend fun invoke(user: User): List<UserTagInfo> {
        with (Dispatchers.IO) {
            return tagInfoRepository.getTagsForUser(user)
        }
    }
}