package com.clydelizardo.stackexchangeusers.userlist.viewmodel

import androidx.lifecycle.*
import com.clydelizardo.stackexchangeusers.model.User
import com.clydelizardo.stackexchangeusers.userlist.usecase.FindUsers
import com.clydelizardo.stackexchangeusers.userlist.view.model.UserListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class UserSearchListViewModel @Inject constructor(
    findUsers: FindUsers,
) : ViewModel() {
    val searchInput = MutableLiveData<String>()

    private val searchText = MutableLiveData<String>()

    private val _searchResults: LiveData<SearchState> = searchText.switchMap {
        liveData {
            emit(SearchState.Loading)
            try {
                emit(SearchState.Success(findUsers(it)))
            } catch (e: Exception) {
                emit(SearchState.Failure(e))
            }
        }
    }
    val resultsList: LiveData<List<UserListItem<*>>> by lazy {
        _searchResults.map {
            when (it) {
                SearchState.Loading -> listOf(UserListItem.Loading)
                is SearchState.Failure -> listOf(UserListItem.Failed)
                is SearchState.Success -> if (it.list.isEmpty()) {
                    listOf(UserListItem.Empty)
                } else {
                    it.list.map { user ->
                        UserListItem.User(user)
                    }
                }
            }
        }
    }

    fun onSearch() {
        searchText.value = searchInput.value
    }

    private sealed class SearchState {
        object Loading : SearchState()
        class Failure(val exception: Exception) : SearchState()
        data class Success(val list: List<User>) : SearchState()
    }
}