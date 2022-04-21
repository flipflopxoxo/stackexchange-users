package com.clydelizardo.stackexchangeusers.repository

import com.clydelizardo.stackexchangeusers.model.User

interface UserRepository {
    suspend fun findUsers(query: String): List<User>
}