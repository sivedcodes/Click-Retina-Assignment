package com.prashant.clickretina.view.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.prashant.clickretina.repository.Result
import com.prashant.clickretina.view.component.ErrorMessage
import com.prashant.clickretina.view.component.ProfileSuccessLayout
import com.prashant.clickretina.viewmodel.UserViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserScreen(viewModel: UserViewModel = koinViewModel()) {
    val userState by viewModel.userState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        when (val state = userState) {
            is Result.Loading -> {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator()
                }
            }
            is Result.Success -> {
                ProfileSuccessLayout(userData = state.data.user)
            }
            is Result.Error -> {
                ErrorMessage(
                    message = state.exception.message ?: "An unknown error occurred",
                    onRetry = { viewModel.fetchUserData() }
                )
            }
        }
    }
}









