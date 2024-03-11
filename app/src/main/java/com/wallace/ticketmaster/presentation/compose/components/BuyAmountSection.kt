package com.wallace.ticketmaster.presentation.compose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.wallace.ticketmaster.R

@Composable
fun BuyAmountSection(
    quantity: String = "",
    onQuantityChange: (String) -> Unit = {},
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 32.dp)
    ) {
        Row {
            QuantitySelector(
                modifier = Modifier
                    .height(70.dp)
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .weight(1F),
                quantity = quantity,
                onQuantityChange = onQuantityChange
            )
            Button(
                onClick = onClick,
                modifier = Modifier
                    .height(64.dp)
                    .weight(1F)
                    .padding(
                        top = 8.dp,
                        bottom = 4.dp,
                        start = 4.dp,
                        end = 4.dp
                    ),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF77D353))
            ) {
                Text(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    text = stringResource(R.string.btn_event_card_buy)
                )
            }
        }
    }
}