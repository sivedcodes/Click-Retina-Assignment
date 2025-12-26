package com.prashant.clickretina.view.component

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prashant.clickretina.model.UserData
import com.prashant.clickretina.view.ContentTabs
import com.prashant.clickretina.view.FollowerStats
import com.prashant.clickretina.view.ProfileHeader
import com.prashant.clickretina.view.SocialLinks

@Composable
fun ProfileSuccessLayout(userData: UserData) {
    val context = LocalContext.current
    val onSocialClick: (String) -> Unit = { url ->
        CustomTabsIntent.Builder().build().launchUrl(context, Uri.parse(url))
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F8FA))
    ) {
        val headerHeight = 220.dp

        Column {
            Spacer(modifier = Modifier.height(headerHeight - 60.dp))
            Surface(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp),
                color = Color.White,
                shadowElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier.padding(top = 80.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = userData.name,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1D262C)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${userData.location.city}, ${userData.location.country}",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    FollowerStats(
                        followers = userData.statistics.followers,
                        following = userData.statistics.following
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    SocialLinks(
                        website = userData.social.website,
                        profiles = userData.social.profiles,
                        onSocialClick = onSocialClick
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    ContentTabs()
                }
            }
        }

        ProfileHeader(
            headerHeight = headerHeight,
            username = userData.username,
            avatarUrl = userData.avatar
        )
    }
}