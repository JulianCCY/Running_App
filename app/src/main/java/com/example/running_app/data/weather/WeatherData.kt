package com.example.running_app.data.weather

import java.time.LocalDateTime

data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType,
    val apparentTemperatureCelsius: Double,
    val rain: Double,
    val snowfall: Double,
)