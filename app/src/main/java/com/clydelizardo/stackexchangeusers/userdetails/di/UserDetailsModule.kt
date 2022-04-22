package com.clydelizardo.stackexchangeusers.userdetails.di

import com.clydelizardo.stackexchangeusers.userdetails.usecase.GetTopTagsUseCase
import com.clydelizardo.stackexchangeusers.userdetails.usecase.GetTopTagsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UserDetailsModule {
    @Binds
    fun getTopTagsUseCase(useCaseImpl: GetTopTagsUseCaseImpl): GetTopTagsUseCase
}