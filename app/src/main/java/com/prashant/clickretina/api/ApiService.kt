package com.prashant.clickretina.api

import com.prashant.clickretina.model.UserResponse
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService {
    suspend fun getUserData(): UserResponse {
        return ApiClient.httpClient.get(ApiRoutes.PROFILE_URL).body()
    }
}