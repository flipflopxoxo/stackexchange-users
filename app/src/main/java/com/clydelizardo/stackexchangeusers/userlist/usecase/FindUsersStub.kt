package com.clydelizardo.stackexchangeusers.userlist.usecase

import com.clydelizardo.stackexchangeusers.model.User
import kotlinx.coroutines.delay
import java.util.*
import javax.inject.Inject

class FindUsersStub @Inject constructor(): FindUsers {
    override suspend fun invoke(query: String): List<User> {
        delay(500)
        return listOf(
            User(id = 0, name = "mark", reputation = 1, topTags = emptyList(), location = "London, UK", creationDate = Date(), profileImageUrl = ""),
            User(id = 1, name = "bryan", reputation = 1, topTags = emptyList(), location = "London, UK", creationDate = Date(), profileImageUrl = ""),
            User(id = 2, name = "sam", reputation = 1, topTags = emptyList(), location = "London, UK", creationDate = Date(), profileImageUrl = ""),
            User(id = 3, name = "steve", reputation = 1, topTags = emptyList(), location = "London, UK", creationDate = Date(), profileImageUrl = ""),
        )
    }
}