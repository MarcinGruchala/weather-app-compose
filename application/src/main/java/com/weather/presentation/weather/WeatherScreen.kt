package com.weather.presentation.weather

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.weather.R
import com.weather.presentation.weather.daily.DailyForecast
import com.weather.presentation.weather.daily.DailyForecastModel
import com.weather.presentation.weather.grid.GridForecast
import com.weather.presentation.weather.grid.GridForecastModel
import com.weather.presentation.weather.hourly.HourlyForecast
import com.weather.presentation.weather.hourly.HourlyForecastModel
import com.weather.ui.theme.WeatherTheme

@Composable
fun WeatherScreen(
    navHostController: NavHostController,
    state: State<WeatherState>
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 6.dp)
            .background(MaterialTheme.colors.background)
    ) {
        val (forecast, bottomBar) = createRefs()
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .constrainAs(forecast) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(bottomBar.top, margin = 6.dp)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        ) {
            item { WeatherHeader(state = state) }
            item { HourlyForecast(hourlyForecast = state.value.hourlyForecast) }
            item { DailyForecast(dailyForecast = state.value.dailyForecast) }
            item { GridForecast(model = state.value.gridForecastModel) }
        }

        Row(
            modifier = Modifier.constrainAs(bottomBar) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                height = Dimension.wrapContent
                width = Dimension.fillToConstraints
            },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                color = MaterialTheme.colors.onPrimary,
                text = "Last update: ${state.value.lastUpdate}"
            )
            IconButton(onClick = { navHostController.navigate(route = "locations") }) {
                Icon(
                    imageVector = Icons.Filled.List,
                    tint = MaterialTheme.colors.onPrimary,
                    contentDescription = "Localized description")
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true, backgroundColor = 0xFF669FFF)
@Composable
fun WeatherDetailsScreenPreview() {

    val mockHourlyItem = HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "1")
    val hourlyForecastMock = List(24) { mockHourlyItem }

    val dailyForecastItemMock = DailyForecastModel(
        day = "Monday",
        icon = R.drawable.rain_day,
        tempMax = 22,
        tempMin = 13
    )
    val dailyForecastMock = List(7) { dailyForecastItemMock }

    val mockGridForecast = GridForecastModel(
        windDeg = 45,
        windSpeed = 9,
        sunRise = "6:59",
        sunSet = "20:45",
        pressure = 1024,
        humidity = 10
    )

    val mockState = mutableStateOf(
        WeatherState(
            location = "Wrocław",
            temp = 33,
            description = "Clear Sky",
            hourlyForecast = hourlyForecastMock,
            dailyForecast = dailyForecastMock,
            gridForecastModel = mockGridForecast,
            lastUpdate = "12:32"
        )
    )
    WeatherTheme {
        WeatherScreen(
            navHostController = rememberNavController(),
            mockState
        )
    }
}
