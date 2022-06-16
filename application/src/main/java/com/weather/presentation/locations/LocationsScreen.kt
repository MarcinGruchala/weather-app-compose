package com.weatherappcomposedemo.presentatnion.locations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.weather.ui.theme.Onyx
import com.weather.ui.theme.Orange50
import com.weather.ui.theme.WeatherTheme

@Composable
fun LocationsScreen() {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            val (locationSearch, searchButton) = createRefs()
            var locationText by remember { mutableStateOf("") }
            OutlinedTextField(
                value = locationText,
                onValueChange = { locationText = it },
                label = { Text(text = "Search for location") },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Orange50,
                    backgroundColor = Onyx,
                    disabledLabelColor = Orange50,
                    focusedLabelColor = Orange50,
                    unfocusedLabelColor = Orange50,
                    cursorColor = Orange50,
                    placeholderColor = Orange50,
                    focusedIndicatorColor = Orange50
                ),
                modifier = Modifier
                    .constrainAs(locationSearch) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(searchButton.start)
                        width = Dimension.fillToConstraints
                    }
            )

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .constrainAs(searchButton) {
                        top.linkTo(locationSearch.top)
                        bottom.linkTo(locationSearch.bottom)
                        start.linkTo(locationSearch.end, margin = 10.dp)
                        end.linkTo(parent.end)
                        height = Dimension.fillToConstraints
                    }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search",
                    tint = Orange50,
                    modifier = Modifier.size(26.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF669FFF)
@Composable
fun LocationScreenPreview() {
    WeatherTheme {
        LocationsScreen()
    }
}
