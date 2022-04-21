package com.clydelizardo.stackexchangeusers.userlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clydelizardo.stackexchangeusers.userlist.view.model.UserListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserSearchListViewModel @Inject constructor(): ViewModel() {
    val searchInput = MutableLiveData<String>()

    private val searchText = MutableLiveData<String>()

    val _searchResults = MutableLiveData<List<UserListItem<*>>>()
    val resultsList: LiveData<List<UserListItem<*>>>
        get() = _searchResults

    fun onSearch() {
        //TODO
    }
}