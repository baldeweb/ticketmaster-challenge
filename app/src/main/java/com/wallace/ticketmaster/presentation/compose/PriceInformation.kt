package com.wallace.ticketmaster.presentation.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PriceInformation(price: String, isLowest: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            color = Color(0xFF242424),
            fontSize = 14.sp,
            text = if (isLowest) "Lowest ticket price:" else "Most expensive ticket price:",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            color = Color(0xFF242424),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            text = price,
            style = MaterialTheme.typography.body1
        )
    }
}