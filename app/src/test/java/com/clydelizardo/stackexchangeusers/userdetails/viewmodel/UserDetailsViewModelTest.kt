package com.clydelizardo.stackexchangeusers.userdetails.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.testing.TestLifecycleOwner
import com.clydelizardo.stackexchangeusers.model.BadgeCount
import com.clydelizardo.stackexchangeusers.model.User
import com.clydelizardo.stackexchangeusers.model.UserTagInfo
import com.clydelizardo.stackexchangeusers.userdetails.usecase.GetTopTagsForUserUseCase
import com.clydelizardo.stackexchangeusers.userdetails.view.UserDetailsFragmentArgs
import com.clydelizardo.stackexchangeusers.userlist.view.model.UserListItem
import io.mockk.Ordering
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.*

@OptIn(ExperimentalCoroutinesApi::class)
class UserDetailsViewModelTest {
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
    fun `on observe of top tags - no tags are available - top tags shown as no tags available`() {
        val getTopTags: GetTopTagsForUserUseCase = mockk()
        val user = User(id = 0, name = "John Doe", reputation = 1,  location = null, creationDate = Date(0L), profileImageUrl = "", badgeCount = BadgeCount(0, 0, 0))

        coEvery { getTopTags(any()) } returns emptyList()

        val savedStateHandle = UserDetailsFragmentArgs.Builder(user)
            .build().toSavedStateHandle()
        val viewModel = UserDetailsViewModel(
            savedStateHandle = savedStateHandle,
            getTopTagsForUserUseCase = getTopTags
        )

        val resultsObserver: Observer<String> = mockk(relaxed = true)
        val testLifecycleOwner = TestLifecycleOwner(Lifecycle.State.RESUMED)

        viewModel.topTags.observe(testLifecycleOwner, resultsObserver)

        verify(ordering = Ordering.ORDERED) {
            resultsObserver.onChanged("...")
            resultsObserver.onChanged("no tags found")
        }
    }

    @Test
    fun `on observe of top tags - two tags available - top tags shown and formatted`() {
        val getTopTags: GetTopTagsForUserUseCase = mockk()
        val user = User(id = 0, name = "John Doe", reputation = 1,  location = null, creationDate = Date(0L), profileImageUrl = "", badgeCount = BadgeCount(0, 0, 0))

        coEvery { getTopTags(any()) } returns listOf(
            UserTagInfo(tagName = "python", postsCount = 1),
            UserTagInfo(tagName = "java", postsCount = 2),
        )

        val savedStateHandle = UserDetailsFragmentArgs.Builder(user)
            .build().toSavedStateHandle()
        val viewModel = UserDetailsViewModel(
            savedStateHandle = savedStateHandle,
            getTopTagsForUserUseCase = getTopTags
        )

        val resultsObserver: Observer<String> = mockk(relaxed = true)
        val testLifecycleOwner = TestLifecycleOwner(Lifecycle.State.RESUMED)

        viewModel.topTags.observe(testLifecycleOwner, resultsObserver)

        verify(ordering = Ordering.ORDERED) {
            resultsObserver.onChanged("...")
            resultsObserver.onChanged("python: 1 post(s)\njava: 2 post(s)")
        }
    }

    @Test
    fun `on observe of top tags - retrieval fails - Unable to get top tags`() {
        val getTopTags: GetTopTagsForUserUseCase = mockk()
        val user = User(id = 0, name = "John Doe", reputation = 1,  location = null, creationDate = Date(0L), profileImageUrl = "", badgeCount = BadgeCount(0, 0, 0))

        coEvery { getTopTags(any()) } throws Exception()

        val savedStateHandle = UserDetailsFragmentArgs.Builder(user)
            .build().toSavedStateHandle()
        val viewModel = UserDetailsViewModel(
            savedStateHandle = savedStateHandle,
            getTopTagsForUserUseCase = getTopTags
        )

        val resultsObserver: Observer<String> = mockk(relaxed = true)
        val testLifecycleOwner = TestLifecycleOwner(Lifecycle.State.RESUMED)

        viewModel.topTags.observe(testLifecycleOwner, resultsObserver)

        verify(ordering = Ordering.ORDERED) {
            resultsObserver.onChanged("...")
            resultsObserver.onChanged("Unable to get top tags")
        }
    }
}