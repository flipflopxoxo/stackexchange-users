package com.clydelizardo.stackexchangeusers.api

import com.clydelizardo.stackexchangeusers.api.model.UserListResponse
import com.clydelizardo.stackexchangeusers.api.model.toptags.TopTagsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {
    @GET("2.3/users")
    suspend fun getUsers(
        @Query("order")
        order: String,
        @Query("sort")
        sort: String,
        @Query("site")
        site: String,
        @Query("inname")
        searchEntry: String? = null,
        @Query("key")
        key: String,
        @Query("max")
        max: Int = 0
    ): UserListResponse

    @GET("2.3/users/{id}/top-tags")
    suspend fun getTopTags(
        @Path("id")
        userId: Int,
        @Query("site")
        site: String,
        @Query("key")
        key: String
    ): TopTagsResponse
}