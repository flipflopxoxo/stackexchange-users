package com.clydelizardo.stackexchangeusers.userdetails.di

import com.clydelizardo.stackexchangeusers.userdetails.usecase.GetTopTagsForUserUseCase
import com.clydelizardo.stackexchangeusers.userdetails.usecase.GetTopTagsForUserUseCaseImpl
import com.clydelizardo.stackexchangeusers.userlist.usecase.FindUsers
import com.clydelizardo.stackexchangeusers.userlist.usecase.FindUsersByRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UserDetailsModule {
    @Binds
    fun getTopTagsUseCase(useCaseImpl: GetTopTagsForUserUseCaseImpl): GetTopTagsForUserUseCase
}