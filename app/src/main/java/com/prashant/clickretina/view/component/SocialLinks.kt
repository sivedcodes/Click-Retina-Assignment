package com.prashant.clickretina.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.prashant.clickretina.R
import com.prashant.clickretina.model.SocialProfile

@Composable
fun SocialLinks(website: String, profiles: List<SocialProfile>, onSocialClick: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val iconColor = Color(0xFF9E9E9E)
        Icon(
            painter = painterResource(id = R.drawable.icn_internet),
            contentDescription = "Website",
            modifier = Modifier
                .size(20.dp)
                .clickable { onSocialClick(website) },
            tint = iconColor
        )
        Box(modifier = Modifier.size(4.dp).clip(CircleShape).background(iconColor.copy(alpha = 0.5f)))
        Icon(
            painter = painterResource(id = R.drawable.icn_instagram),
            contentDescription = "Instagram",
            modifier = Modifier
                .size(20.dp)
                .clickable { onSocialClick(profiles.first { it.platform == "Instagram" }.url) },
            tint = iconColor
        )
        Box(modifier = Modifier.size(4.dp).clip(CircleShape).background(iconColor.copy(alpha = 0.5f)))
        Icon(
            painter = painterResource(id = R.drawable.icn_facebook),
            contentDescription = "Facebook",
            modifier = Modifier
                .size(20.dp)
                .clickable { onSocialClick(profiles.first { it.platform == "Facebook" }.url) },
            tint = iconColor
        )
    }
}
