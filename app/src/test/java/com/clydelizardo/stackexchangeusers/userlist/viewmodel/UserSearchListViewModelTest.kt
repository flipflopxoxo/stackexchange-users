package com.clydelizardo.stackexchangeusers.userlist.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import androidx.lifecycle.testing.TestLifecycleOwner
import com.clydelizardo.stackexchangeusers.model.User
import com.clydelizardo.stackexchangeusers.userlist.usecase.FindUsers
import com.clydelizardo.stackexchangeusers.userlist.view.model.UserListItem
import io.mockk.Ordering
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.*

@OptIn(ExperimentalCoroutinesApi::class)
class UserSearchListViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `on search of text - result is not empty - list is populated`() {
        val findUsers: FindUsers = mockk()
        val resultItem = User(id = 0, name = "John Doe", reputation = 1, topTags = emptyList(), location = null, creationDate = Date(0L))

        coEvery { findUsers(any()) } returns listOf(resultItem)
        val viewModel = UserSearchListViewModel(
            findUsers = findUsers
        )

        val resultsObserver: Observer<List<UserListItem<*>>> = mockk(relaxed = true)
        val testLifecycleOwner = TestLifecycleOwner(Lifecycle.State.RESUMED)

        viewModel.resultsList.observe(testLifecycleOwner, resultsObserver)

        viewModel.searchInput.value = "hello"

        viewModel.onSearch()

        verify(ordering = Ordering.ORDERED) {
            resultsObserver.onChanged(listOf(UserListItem.Loading))
            resultsObserver.onChanged(listOf(UserListItem.User(resultItem)))
        }
    }

    @Test
    fun `on search of text - result is empty - list contains Empty list item`() {
        val findUsers: FindUsers = mockk()

        coEvery { findUsers(any()) } returns emptyList()
        val viewModel = UserSearchListViewModel(
            findUsers = findUsers
        )

        val resultsObserver: Observer<List<UserListItem<*>>> = mockk(relaxed = true)
        val testLifecycleOwner = TestLifecycleOwner(Lifecycle.State.RESUMED)

        viewModel.resultsList.observe(testLifecycleOwner, resultsObserver)

        viewModel.searchInput.value = "hello"

        viewModel.onSearch()

        verify(ordering = Ordering.ORDERED) {
            resultsObserver.onChanged(listOf(UserListItem.Loading))
            resultsObserver.onChanged(listOf(UserListItem.Empty))
        }
    }

    @Test
    fun `on search of text - request fails - list contains Failure list item`() {
        val findUsers: FindUsers = mockk()

        coEvery { findUsers(any()) } throws Exception()
        val viewModel = UserSearchListViewModel(
            findUsers = findUsers
        )

        val resultsObserver: Observer<List<UserListItem<*>>> = mockk(relaxed = true)
        val testLifecycleOwner = TestLifecycleOwner(Lifecycle.State.RESUMED)

        viewModel.resultsList.observe(testLifecycleOwner, resultsObserver)

        viewModel.searchInput.value = "hello"

        viewModel.onSearch()

        verify(ordering = Ordering.ORDERED) {
            resultsObserver.onChanged(listOf(UserListItem.Loading))
            resultsObserver.onChanged(listOf(UserListItem.Failed))
        }
    }
}