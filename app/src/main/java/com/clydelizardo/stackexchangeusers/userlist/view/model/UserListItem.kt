package com.clydelizardo.stackexchangeusers.userlist.view.model

import androidx.annotation.LayoutRes
import com.clydelizardo.stackexchangeusers.R
import com.clydelizardo.stackexchangeusers.model.User

typealias UserModel = User

sealed class UserListItem<T> constructor(
    @LayoutRes
    val resourceId: Int,
) {
    abstract val content: T

    data class User(override val content: UserModel): UserListItem<UserModel>(R.layout.item_user)

    object Loading: UserListItem<Any?>(R.layout.item_loading) {
        override val content = null
    }
    object Failed: UserListItem<Any?>(R.layout.item_failed) {
        override val content = null
    }
    object Empty: UserListItem<Any?>(R.layout.item_empty) {
        override val content = null
    }
}