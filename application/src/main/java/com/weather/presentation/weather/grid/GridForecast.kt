package com.weather.presentation.weather.grid

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.weather.ui.theme.DarkBlue

@Composable
fun GridForecast(model: GridForecastModel) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            WindItem(model = model)
            SunItem(model = model)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            PressureItem(model = model)
            HumidityItem(model = model)
        }
    }
}

@Composable
fun WindItem(model: GridForecastModel) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .size(150.dp),
        elevation = 4.dp,
        backgroundColor = DarkBlue
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Wind speed:")
            Text(text = "${model.windSpeed} km/h")
            Text(text = "Wind deg:")
            Text(text = "${model.windDeg} deg")
        }
    }
}

@Composable
fun SunItem(model: GridForecastModel) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .size(150.dp),
        elevation = 4.dp,
        backgroundColor = DarkBlue
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sunrise:")
            Text(text = model.sunRise)
            Text(text = "Sunset:")
            Text(text = model.sunSet)
        }
    }
}

@Composable
fun PressureItem(model: GridForecastModel) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .size(150.dp),
        elevation = 4.dp,
        backgroundColor = DarkBlue
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Pressure:")
            Text(text = "${model.pressure} Pa")
        }
    }
}

@Composable
fun HumidityItem(model: GridForecastModel) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .size(150.dp),
        elevation = 4.dp,
        backgroundColor = DarkBlue
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Humidity:")
            Text(text = "${model.pressure} %")
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFF669FFF)
@Composable
fun GridForecastPreview() {
    val mockModel = GridForecastModel(
        windDeg = 45,
        windSpeed = 9,
        sunRise = "6:59",
        sunSet = "20:45",
        pressure = 1024,
        humidity = 10
    )

    GridForecast(model = mockModel)

}
