package com.example.running_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.running_app.views.MainScreen
import com.example.running_app.ui.theme.Running_AppTheme
import com.example.running_app.views.WeatherScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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