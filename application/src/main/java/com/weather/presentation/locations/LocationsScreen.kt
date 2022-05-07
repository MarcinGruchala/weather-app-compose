package com.weatherappcomposedemo.presentatnion.locations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.weather.ui.theme.WeatherTheme

@Composable
fun LocationsScreen() {
  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Text(text = "Locations Screen")
  }
}

@Preview(showBackground = true,backgroundColor = 0xFF669FFF)
@Composable
fun LocationScreenPreview(){
  WeatherTheme {
    LocationsScreen()
  }
}
