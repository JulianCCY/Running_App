package com.example.running_app

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.running_app.data.weather.WeatherCard
import com.example.running_app.data.weather.display.DailyWeatherForecasting
import com.example.running_app.data.weather.display.WeatherForecasting
import com.example.running_app.data.weather.viewmodel.DailyWeatherViewModel
import com.example.running_app.data.weather.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.running_app.views.MainScreen
import com.example.running_app.ui.theme.Running_AppTheme
import com.example.running_app.views.RunningScreen
import com.example.running_app.views.WeatherScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val weatherViewModel: WeatherViewModel by viewModels()
    private val dailyWeatherViewModel: DailyWeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ){
            weatherViewModel.loadWeatherInfo()
            dailyWeatherViewModel.loadDailyWeatherInfo()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        ))
        setContent {
            val navController = rememberNavController()
            Running_AppTheme {
                // A surface container using the 'background' color from the theme
                rememberSystemUiController().setStatusBarColor(
                    color = MaterialTheme.colors.background
                )
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(navController, startDestination = "main") {
                        composable("main") {
                            MainScreen(navController)
                        }
                        composable("weather") {
                            WeatherScreen()
                        }
                        composable("tracks") {

                        }
                        composable("stats") {

                        }
                        composable("training") {

                        }
                        composable("startRunning") {
                            RunningScreen()
                        }
                    }
                }
            }       
        }
    }
}

//@Composable
//fun MainView() {
//    val navController = rememberNavController()
//    val sdf1 = SimpleDateFormat("dd/MM/yyyy")
//    val sdf2 = SimpleDateFormat("HH:mm")
//    val date = sdf1.format(Date())
//    val time = sdf2.format(Date())
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//    ) {
//        Text(text = date)
//        Text(text = time)
//        NavHost(navController, startDestination = "home") {
//            composable("home") {
//
//            }
//            composable("weather") {
//
//            }
//            composable("suggestedTracks") {
//
//            }
//            composable("stats") {
//
//            }
//            composable("training") {
//
//            }
//            composable("startRunning") {
//
//            }
//        }
//    }
//}
//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    Running_AppTheme {
//        Greeting("Android")
//    }
//}