package com.weather.presentation.locations

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toolingGraphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.weather.ui.theme.Onyx
import com.weather.ui.theme.Orange50
import com.weather.ui.theme.Red35
import com.weather.ui.theme.WeatherTheme

@Composable
fun LocationsFragmentScreen() {
    val viewModel: LocationsViewModel = hiltViewModel()
    val state = viewModel.state.collectAsState()
    LocationsScreen(
        state = state,
        onSearchClick = { location -> viewModel.onLocationSearchButtonClicked(location) }
    )
}

@Composable
fun LocationsScreen(
    state: State<LocationsViewModel.LocationsScreenState>,
    onSearchClick: (String) -> Unit
) {
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
            val (
                locationSearch,
                searchButton,
                errorMessage,
                currentLocationText
            ) = createRefs()
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
                isError = state.value.isError,
                trailingIcon = {
                    if (state.value.isError) {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            tint = Red35,
                            contentDescription = ""
                        )
                    }
                },
                modifier = Modifier
                    .constrainAs(locationSearch) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(searchButton.start)
                        width = Dimension.fillToConstraints
                    }
            )

            IconButton(
                onClick = { onSearchClick(locationText) },
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

            if (state.value.isError)
                Text(
                    text = "Wrong location",
                    color = Red35,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .constrainAs(errorMessage) {
                            top.linkTo(locationSearch.bottom, margin = 4.dp)
                            start.linkTo(parent.start)
                        }
                )

            Text(
                text = "Current location: ${state.value.currentLocation}",
                color = Orange50,
                fontSize = 20.sp,
                modifier = Modifier
                    .constrainAs(currentLocationText) {
                        top.linkTo(locationSearch.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true, backgroundColor = 0xFF669FFF)
@Composable
fun LocationScreenPreview() {
    val mockState = mutableStateOf(
        LocationsViewModel.LocationsScreenState(
            currentLocation = "Wroclaw",
            isError = true
        )
    )

    WeatherTheme {
        LocationsScreen(
            state = mockState,
            onSearchClick = {}
        )
    }
}
