package com.weather.presentation.weather.daily

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.weather.R
import com.weather.ui.theme.WeatherTheme

@Composable
fun DailyForecast(dailyForecast: List<DailyForecastModel>) {
    Card(
        modifier = Modifier.padding(top = 10.dp),
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.primaryVariant
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            dailyForecast.forEach {
                DailyForecastItem(model = it)
            }
        }
    }
}

@Composable
fun DailyForecastItem(model: DailyForecastModel) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            fontSize = 16.sp,
            text = model.day,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
        Image(
            painter = painterResource(id = model.icon),
            contentDescription = null,
            modifier = Modifier.weight(1f)
        )
        Text(
            fontSize = 16.sp,
            text = "${model.tempMin} °C",
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
        Text(
            fontSize = 16.sp,
            text = "${model.tempMax} °C",
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF669FFF)
@Composable
fun DailyForecastPreview() {
    val mockModel = DailyForecastModel(
        day = "Monday",
        icon = R.drawable.rain_day,
        tempMax = 22,
        tempMin = 13
    )
    val mockList = List(7) { mockModel }

    WeatherTheme {
        DailyForecast(dailyForecast = mockList)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF669FFF)
@Composable
fun DailyForecastItemPreview() {
    val mockModel = DailyForecastModel(
        day = "Monday",
        icon = R.drawable.rain_day,
        tempMax = 22,
        tempMin = 13
    )

    WeatherTheme {
        DailyForecastItem(mockModel)
    }

}
