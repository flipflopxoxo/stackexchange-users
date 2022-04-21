package com.clydelizardo.stackexchangeusers.userlist.usecase

import com.clydelizardo.stackexchangeusers.model.User

fun interface FindUsers {
    suspend operator fun invoke(query: String): List<User>
}