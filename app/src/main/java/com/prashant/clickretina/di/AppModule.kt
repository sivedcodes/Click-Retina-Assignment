package com.prashant.clickretina.di

import com.prashant.clickretina.api.ApiClient
import com.prashant.clickretina.api.ApiService
import com.prashant.clickretina.repository.UserRepository
import com.prashant.clickretina.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { ApiClient.httpClient }
    single { ApiService() }
    single { UserRepository(get()) }
    viewModel { UserViewModel(get()) }
}