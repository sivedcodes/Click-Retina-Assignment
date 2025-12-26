package com.prashant.clickretina.view.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.prashant.clickretina.view.screen.UserScreen
import com.prashant.clickretina.view.theme.ClickRetinaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClickRetinaTheme {
                Surface(
                    modifier = Modifier.Companion.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
    ClickRetinaTheme {
        UserScreen()
    }
}