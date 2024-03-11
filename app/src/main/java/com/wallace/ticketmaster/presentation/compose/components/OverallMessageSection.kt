package com.wallace.ticketmaster.presentation.compose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun OverallMessageSection(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 32.dp,
                bottom = 12.dp,
                start = 32.dp,
                end = 32.dp
            )
            .height(90.dp),
        elevation = 12.dp,
        backgroundColor = Color(0xFFF8E0B8),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(width = 0.25.dp, color = Color.LightGray)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            Text(
                modifier = Modifier.padding(
                    vertical = 16.dp,
                    horizontal = 24.dp
                ),
                color = Color(0xFF242424),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1,
                text = text,
                textAlign = TextAlign.Center
            )
        }
    }
}