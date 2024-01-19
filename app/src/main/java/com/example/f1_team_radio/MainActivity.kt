package com.example.f1_team_radio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.f1_team_radio.model.DEFAULT_DRIVER_NUMBER
import com.example.f1_team_radio.model.DEFAULT_MEETING_KEY
import com.example.f1_team_radio.model.DEFAULT_SESSION_KEY
import com.example.f1_team_radio.model.MainViewModel
import com.example.f1_team_radio.ui.screens.DriverScreen
import com.example.f1_team_radio.ui.screens.MeetingScreen
import com.example.f1_team_radio.ui.screens.RadioScreen
import com.example.f1_team_radio.ui.screens.SessionScreen
import com.example.f1_team_radio.ui.theme.F1TeamRadioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            F1TeamRadioTheme(
                dynamicColor = false
            ) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation(){

    val navController : NavHostController = rememberNavController()
    val viewModel : MainViewModel = viewModel()




    NavHost(navController = navController,
        startDestination = Routes.MeetingScreen.route
    ) {

        composable(Routes.MeetingScreen.route) {
            MeetingScreen(navController, viewModel)
        }

        composable(Routes.SessionScreen.route,
            arguments = listOf(
                navArgument("meetingKey"){ type = NavType.IntType}
            )
        ) {
            val meetingKey = it.arguments?.getInt("meetingKey", DEFAULT_MEETING_KEY) ?: DEFAULT_MEETING_KEY
            SessionScreen(viewModel=viewModel,meetingKey=meetingKey,navController=navController)
        }

        composable(Routes.DriverScreen.route,
            arguments = listOf(
                navArgument("sessionKey"){ type = NavType.IntType}
            )
        ) {
            val sessionKey = it.arguments?.getInt("sessionKey", DEFAULT_SESSION_KEY) ?: DEFAULT_SESSION_KEY
            DriverScreen(viewModel=viewModel,sessionKey=sessionKey,navController=navController)
        }

        composable(Routes.RadioScreen.route,
            arguments = listOf(
                navArgument("sessionKey"){ type = NavType.IntType},
                navArgument("driverNumber"){type= NavType.IntType}
            )
        ) {
            println(it.arguments)
            val sessionKey = it.arguments?.getInt("sessionKey", DEFAULT_SESSION_KEY) ?: DEFAULT_SESSION_KEY
            val driverNumber = it.arguments?.getInt("driverNumber", DEFAULT_DRIVER_NUMBER) ?: DEFAULT_DRIVER_NUMBER
            RadioScreen(viewModel=viewModel,sessionKey=sessionKey, driverNumber = driverNumber, navController = navController)
        }

    }

}