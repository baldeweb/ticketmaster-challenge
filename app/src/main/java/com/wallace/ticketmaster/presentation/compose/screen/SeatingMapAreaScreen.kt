package com.wallace.ticketmaster.presentation.compose.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.wallace.ticketmaster.R
import com.wallace.ticketmaster.data.utils.openBrowse
import com.wallace.ticketmaster.domain.dto.BuySessionDTO
import com.wallace.ticketmaster.presentation.compose.PriceInformation
import com.wallace.ticketmaster.presentation.compose.components.BuyAmountSection
import com.wallace.ticketmaster.presentation.compose.components.OverallMessageSection

@Composable
fun SeatingMapAreaScreen(
    dto: BuySessionDTO,
    modifier: Modifier,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    var quantity by remember { mutableStateOf("") }

    Column(
        modifier = modifier
    ) {
        TopAppBar(
            modifier = Modifier.height(80.dp),
            title = {
                Text(
                    color = Color.White,
                    text = "Buy Session"
                )
            },
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(
                        contentDescription = "Back",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(start = 8.dp),
                        painter = painterResource(id = R.drawable.left_arrow),
                        tint = Color.White
                    )
                }
            },
            backgroundColor = MaterialTheme.colors.primary
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            SeatMapSection(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                imageSeatMapUrl = dto.imageSeatMapUrl ?: ""
            )
            OverallMessageSection(text = dto.overallMessageParam ?: "")
            PriceSection(
                lowestPrice = dto.lowestPrice ?: "(error)",
                highestPrice = dto.highestPrice ?: "(error)"
            )
            BuyAmountSection(
                quantity = quantity,
                onQuantityChange = { quantity = it },
                onClick = {
                    context.openBrowse(dto.buyUrl ?: "")
                }
            )
        }
    }
}

@Composable
fun SeatMapSection(
    modifier: Modifier,
    imageSeatMapUrl: String
) {
    Text(
        color = MaterialTheme.colors.secondary,
        fontWeight = FontWeight.Bold,
        modifier = modifier,
        style = MaterialTheme.typography.h5,
        text = "Seating Map Area"
    )

    val painter = rememberAsyncImagePainter(
        model = imageSeatMapUrl,
        onState = { state ->
        }
    )

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
        .padding(vertical = 16.dp, horizontal = 8.dp)) {
        Image(
            painter = painter,
            contentDescription = "Seating Map",
            modifier = Modifier.matchParentSize()
        )

        if (painter.state is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(80.dp)
            )
        }
    }
}

@Composable
fun PriceSection(
    lowestPrice: String,
    highestPrice: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 32.dp)
            .height(90.dp),
        elevation = 12.dp,
        backgroundColor = Color(0xFFF0F0F0),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(width = 0.25.dp, color = Color.LightGray)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            Column {
                PriceInformation(price = lowestPrice, isLowest = true)
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .height(1.dp)
                        .padding(vertical = 4.dp, horizontal = 16.dp)
                )
                PriceInformation(price = highestPrice, isLowest = false)
            }
        }
    }
}