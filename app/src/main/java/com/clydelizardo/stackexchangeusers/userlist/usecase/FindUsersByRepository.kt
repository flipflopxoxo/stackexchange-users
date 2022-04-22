package com.clydelizardo.stackexchangeusers.userlist.usecase

import com.clydelizardo.stackexchangeusers.model.User
import com.clydelizardo.stackexchangeusers.repository.UserRepository
import javax.inject.Inject

class FindUsersByRepository @Inject constructor(
    private val userRepository: UserRepository
) : FindUsers {
    override suspend fun invoke(query: String): List<User> {
        return userRepository.findUsers(query)
    }
}