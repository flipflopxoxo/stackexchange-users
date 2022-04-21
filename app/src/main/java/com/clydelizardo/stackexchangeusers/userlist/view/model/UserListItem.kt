package com.clydelizardo.stackexchangeusers.userlist.view.model

import androidx.annotation.LayoutRes
import com.clydelizardo.stackexchangeusers.R
import com.clydelizardo.stackexchangeusers.model.User

typealias UserModel = User

sealed class UserListItem<T> (
    @LayoutRes
    val resourceId: Int,
    val content: T
) {
    class User(content: UserModel): UserListItem<UserModel>(R.layout.item_user, content)

    object Loading: UserListItem<Any?>(R.layout.item_loading, null)
    object Failed: UserListItem<Any?>(R.layout.item_failed, null)
    object Empty: UserListItem<Any?>(R.layout.item_empty, null)
}