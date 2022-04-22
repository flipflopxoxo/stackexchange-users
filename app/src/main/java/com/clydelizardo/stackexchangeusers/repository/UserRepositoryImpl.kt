package com.clydelizardo.stackexchangeusers.repository

import com.clydelizardo.stackexchangeusers.api.ApiConstants
import com.clydelizardo.stackexchangeusers.api.UserService
import com.clydelizardo.stackexchangeusers.api.model.CollectiveMembership
import com.clydelizardo.stackexchangeusers.api.model.UserApiModel
import com.clydelizardo.stackexchangeusers.model.BadgeCount
import com.clydelizardo.stackexchangeusers.model.User
import kotlinx.coroutines.Dispatchers
import java.util.*
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService,
) : UserRepository {
    override suspend fun findUsers(query: String): List<User> {
        val users = userService.getUsers(
            order = "desc",
            sort = "reputation",
            site = "stackoverflow",
            searchEntry = query,
            key = ApiConstants.API_KEY,
            max = 20
        )
        with (Dispatchers.IO) {
            return users.items?.map { user ->
                user.collectives
                User(
                    id = user.userId,
                    name = user.displayName,
                    reputation = user.reputation,
                    location = user.location,
                    creationDate = Date(user.creationDate.toLong() * 1_000),
                    profileImageUrl = user.profileImage,
                    badgeCount = extractBadgeCount(user)
                )
            } ?: emptyList()
        }
    }
}

private fun extractBadgeCount(user: UserApiModel): BadgeCount {
    return BadgeCount(
        bronze = user.badgeCounts.bronze,
        silver = user.badgeCounts.silver,
        gold = user.badgeCounts.gold
    )
}