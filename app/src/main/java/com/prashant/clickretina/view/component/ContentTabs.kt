package com.prashant.clickretina.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prashant.clickretina.view.EmptyStateContent

@Composable
fun ContentTabs() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Shots", "Collections")

    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.White,
        contentColor = Color(0xFF5E42E6),
        indicator = { },
        divider = { }
    ) {
        tabs.forEachIndexed { index, title ->
            val isSelected = selectedTabIndex == index
            val background = if (isSelected) {
                Brush.horizontalGradient(
                    colors = listOf(Color(0xFF8338EC), Color(0xFF5E42E6))
                )
            } else {
                Brush.horizontalGradient(colors = listOf(Color(0xFFF0F2F8), Color(0xFFF0F2F8))) // FIX: Light grey bg for non-selected
            }
            val textColor = if (isSelected) Color.White else Color.Gray

            Tab(
                selected = isSelected,
                onClick = { selectedTabIndex = index },
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 12.dp)
                    .height(44.dp)
                    .clip(RoundedCornerShape(22.dp))
                    .background(background),
                text = {
                    val count = if (title == "Shots") "0" else "10"
                    Text(
                        text = "$count $title",
                        fontWeight = FontWeight.Bold,
                        color = textColor,
                        fontSize = 14.sp
                    )
                }
            )
        }
    }

    Spacer(modifier = Modifier.height(16.dp))
    if (selectedTabIndex == 0) {
        EmptyStateContent()
    }
}