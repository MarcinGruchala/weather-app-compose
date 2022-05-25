package com.weather.presentation.weather

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.weather.ui.theme.WeatherTheme

@Composable
fun WeatherHeader(
    state: State<WeatherViewModel.WeatherState>
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 10.dp)
    ) {
        LocationName(location = state.value.location)
        LocalTemp(temp = state.value.temp)
        WeatherDescription(description = state.value.description)
    }
}

@Composable
fun LocationName(location: String) {
    Text(
        text = location,
        fontSize = 20.sp
    )
}

@Composable
fun LocalTemp(temp: Int) {
    Text(
        text = "$temp °C",
        fontSize = 30.sp,
        modifier = Modifier
            .padding(top = 10.dp)
    )
}

@Composable
fun WeatherDescription(description: String) {
    Text(
        text = description,
        fontSize = 18.sp
    )
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true, backgroundColor = 0xFF669FFF)
@Composable
fun WeatherHeaderPreview() {

    val mockState = mutableStateOf(
        WeatherViewModel.WeatherState(
            location = "Wrocław",
            temp = 33,
            description = "Sunny"
        )
    )
    WeatherTheme {
        WeatherHeader(
            mockState
        )
    }
}