package com.wallace.ticketmaster.presentation.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBar(onSearch: (String) -> Unit) {
    var searchText by remember { mutableStateOf("") }

    val shape = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 0.dp,
        bottomStart = 24.dp,
        bottomEnd = 24.dp
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF026CDF), shape)
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        TextField(
            value = searchText,
            onValueChange = {
                searchText = it
                onSearch(it)
            },
            modifier = Modifier
                .fillMaxWidth(),
            placeholder = { Text("Type the event name") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search Icon") },
            colors = textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.White,
                leadingIconColor = Color.White,
                placeholderColor = Color.White.copy(alpha = ContentAlpha.medium),
                textColor = Color.White,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { onSearch(searchText) })
        )
    }
}
