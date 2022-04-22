package com.clydelizardo.stackexchangeusers.userdetails.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.clydelizardo.stackexchangeusers.model.User
import com.clydelizardo.stackexchangeusers.userdetails.view.UserDetailsFragmentArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.DateFormat
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val user: User = UserDetailsFragmentArgs.fromSavedStateHandle(savedStateHandle).user

    val profileImageUrl: String = user.profileImageUrl

    val userName: String = user.name

    val reputation: String = user.reputation.toString()

    val topTags: String = if (user.topTags.isNotEmpty()) {
        user.topTags.toTypedArray().joinToString(",")
    } else {
        "-"
    }

    val bronzeBadges: String = user.badgeCount.bronze.toString()
    val silverBadges: String = user.badgeCount.silver.toString()
    val goldBadges: String = user.badgeCount.gold.toString()

    val location: String = user.location ?: "-"
    val creationDate: String = DateFormat.getDateInstance().format(user.creationDate)
}