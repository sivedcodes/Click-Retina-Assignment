package com.prashant.clickretina.repository

import com.prashant.clickretina.api.ApiService
import com.prashant.clickretina.model.UserResponse


class UserRepository(private val apiService: ApiService) {
    suspend fun getUserData(): Result<UserResponse> {
        return try {
            val response = apiService.getUserData()
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()
    object Loading : Result<Nothing>()
}