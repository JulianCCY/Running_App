package com.example.running_app.data.weather.display

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.running_app.data.weather.WeatherState
import java.time.LocalDateTime

@Composable
fun WeatherForecasting(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
//    state.weatherInfo?.weatherDataPerDay?.values?.toList()?.flatten()?.map { it }?.filter { it.time.hour >= LocalDateTime.now().hour || it.time.isAfter(LocalDateTime.now()) }?.slice(0..24)
    state.weatherInfo?.weatherDataPerHour?.values?.toList()?.flatten()?.map { it }?.filter { it.time.hour >= LocalDateTime.now().hour || it.time.isAfter(LocalDateTime.now()) }?.slice(0..24)?.let {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        ) {
            LazyRow(content = {
                items(it) { data ->
                    TwentyFourHoursForecastingDisplay(
                        data,
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
            })
        }
    }

}




//    state.weatherInfo?.weatherDataPerDay?.values.let {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp)
//        ) {
//            Text(
//                "Today",
//                fontSize = 20.sp
//            )
////            Spacer(modifier = Modifier.height(16.dp))
////
////            LazyRow(content = {
////                items(it) { forecasting ->
////
////                }
////            })
//
//
//        }
//    }