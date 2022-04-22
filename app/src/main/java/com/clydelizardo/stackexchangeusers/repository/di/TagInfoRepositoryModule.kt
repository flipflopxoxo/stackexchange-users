package com.clydelizardo.stackexchangeusers.repository.di

import com.clydelizardo.stackexchangeusers.repository.TagInfoRepository
import com.clydelizardo.stackexchangeusers.repository.TagInfoRepositoryImpl
import com.clydelizardo.stackexchangeusers.repository.UserRepository
import com.clydelizardo.stackexchangeusers.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface TagInfoRepositoryModule {
    @Binds
    fun userRepository(repositoryImpl: TagInfoRepositoryImpl): TagInfoRepository
}