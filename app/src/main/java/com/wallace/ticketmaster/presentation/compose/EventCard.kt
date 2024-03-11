package com.wallace.ticketmaster.presentation.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.wallace.ticketmaster.R
import com.wallace.ticketmaster.data.utils.convertHumanDateTime
import com.wallace.ticketmaster.data.utils.toCurrency
import com.wallace.ticketmaster.domain.dto.EventModel

@Composable
fun EventCard(
    event: EventModel,
    onPleaseNotesClicked: () -> Unit,
    onEventCardClick: (String?) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 32.dp)
            .height(200.dp),
        elevation = 12.dp,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            width = 0.25.dp,
            color = Color.LightGray
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            val imgBackground = event.images.find {
                it.ratio == "3_2" && it.width == 640
            }?.url ?: event.images[0].url ?: ""
            val painter = rememberAsyncImagePainter(model = imgBackground)
            Image(
                painter = painter,
                contentDescription = event.accessibility?.info ?: "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                Color.Black.copy(alpha = 0.7F),
                                Color.Black.copy(alpha = 0.7F)
                            )
                        )
                    )
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    modifier = Modifier.padding(end = 48.dp),
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h6,
                    text = event.name ?: "(error)"
                )
                Text(
                    modifier = Modifier.padding(top = 12.dp),
                    color = Color.White,
                    fontSize = 14.sp,
                    text = "Date: ${event.dates?.start?.dateTime?.convertHumanDateTime() ?: "(error)"}",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    color = Color.White,
                    fontSize = 14.sp,
                    text = "Price: ${
                        event.priceRanges?.get(0)?.getAvg()?.toCurrency() ?: "(error)"
                    }",
                    style = MaterialTheme.typography.body2
                )

                Spacer(Modifier.weight(1f))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .clickable { onPleaseNotesClicked.invoke() }
                            .padding(8.dp),
                        text = "Please notes"
                    )

                    Spacer(Modifier.weight(1f))

                    Button(
                        onClick = { onEventCardClick.invoke(event.seatmap?.staticUrl) },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White
                        ),
                    ) {
                        Text(
                            color = Color(0xFF026CDF),
                            fontWeight = FontWeight.Bold,
                            text = stringResource(R.string.btn_event_card_buy)
                        )
                    }
                }
            }
        }
    }
}