package com.clydelizardo.stackexchangeusers.userdetails.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.clydelizardo.stackexchangeusers.model.User
import com.clydelizardo.stackexchangeusers.userdetails.usecase.GetTopTagsForUserUseCase
import com.clydelizardo.stackexchangeusers.userdetails.view.UserDetailsFragmentArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.DateFormat
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getTopTagsForUserUseCase: GetTopTagsForUserUseCase
) : ViewModel() {
    private val user: User = UserDetailsFragmentArgs.fromSavedStateHandle(savedStateHandle).user

    val profileImageUrl: String = user.profileImageUrl

    val userName: String = user.name

    val reputation: String = user.reputation.toString()

    val topTags: LiveData<String> = liveData {
        emit("...")
        try {
            val topTags = getTopTagsForUserUseCase(user)
            if (topTags.isNotEmpty()) {
                emit(topTags.map {
                    "${it.tagName}: ${it.postsCount} post(s)"
                }.joinToString("\n"))
            } else {
                emit("no tags found")
            }
        } catch (_: Exception) {
            emit("Unable to get top tags")
        }
    }

    val bronzeBadges: String = user.badgeCount.bronze.toString()
    val silverBadges: String = user.badgeCount.silver.toString()
    val goldBadges: String = user.badgeCount.gold.toString()

    val location: String = user.location ?: "-"
    val creationDate: String = DateFormat.getDateInstance().format(user.creationDate)
}