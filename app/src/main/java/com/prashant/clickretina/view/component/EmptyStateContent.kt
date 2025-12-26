package com.prashant.clickretina.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prashant.clickretina.R


@Composable
fun EmptyStateContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.icn_empty),
            contentDescription = "Empty State",
            modifier = Modifier.fillMaxWidth(0.7f)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            "Nothing to see here",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xFF1D262C)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "The user hasn't posted any shots yet. Check back later!",
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
    }
}