package com.prashant.clickretina.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prashant.clickretina.model.UserResponse
import com.prashant.clickretina.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.prashant.clickretina.repository.Result

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    private val _userState = MutableStateFlow<Result<UserResponse>>(Result.Loading)
    val userState: StateFlow<Result<UserResponse>> = _userState

    init {
        fetchUserData()
    }

    fun fetchUserData() {
        viewModelScope.launch {
            _userState.value = Result.Loading
            _userState.value = repository.getUserData()
        }
    }
}