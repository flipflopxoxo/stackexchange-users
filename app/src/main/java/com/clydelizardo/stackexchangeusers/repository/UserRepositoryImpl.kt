package com.clydelizardo.stackexchangeusers.repository

import com.clydelizardo.stackexchangeusers.api.UserService
import com.clydelizardo.stackexchangeusers.api.model.CollectiveMembership
import com.clydelizardo.stackexchangeusers.model.User
import kotlinx.coroutines.Dispatchers
import java.util.*
import javax.inject.Inject

const val KEY = "iZWqY2NVKP)hm05iF2)7Iw(("


class UserRepositoryImpl @Inject constructor(
    private val userService: UserService,
) : UserRepository {
    override suspend fun findUsers(query: String): List<User> {
        val users = userService.getUsers(
            order = "desc",
            sort = "reputation",
            site = "stackoverflow",
            searchEntry = query,
            key = KEY,
            max = 20
        )
        with (Dispatchers.IO) {
            return users.items?.map { user ->
                user.collectives
                User(
                    id = user.userId,
                    name = user.displayName,
                    reputation = user.reputation,
                    topTags = findTopTags(user.collectives),
                    location = user.location,
                    creationDate = Date(user.creationDate.toLong())
                )
            } ?: emptyList()
        }
    }
}

private fun findTopTags(collectives: List<CollectiveMembership>?): List<String> {
    if (collectives == null) {
        return emptyList()
    }
    val tagsByApperance = collectives.flatMap {
        it.collective.tags ?: emptyList()
    }.groupingBy { it }
        .eachCount()
    val maxTagAppearance = tagsByApperance.maxOf {
        it.value
    }
    val tags = tagsByApperance.filterValues {
        it == maxTagAppearance
    }.keys.toList()
    return tags
}