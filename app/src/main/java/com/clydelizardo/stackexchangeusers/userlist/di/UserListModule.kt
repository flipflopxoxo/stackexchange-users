package com.clydelizardo.stackexchangeusers.userlist.di

import com.clydelizardo.stackexchangeusers.userlist.usecase.FindUsers
import com.clydelizardo.stackexchangeusers.userlist.usecase.FindUsersByRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UserListModule {
    @Binds
    fun findUsersUserCase(stub: FindUsersByRepository): FindUsers
}