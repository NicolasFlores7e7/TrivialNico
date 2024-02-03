package com.example.trivianico

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trivianico.navigation.Routes
import com.example.trivianico.ui.theme.TriviaNicoTheme
import com.example.trivianico.view.Game
import com.example.trivianico.view.Menu
import com.example.trivianico.view.Result
import com.example.trivianico.view.Settings
import com.example.trivianico.viewModel.GameViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameViewModel: GameViewModel by viewModels()
        setContent {
            TriviaNicoTheme {
                var bgColor by remember { mutableStateOf(gameViewModel.appColors[3]) }
                bgColor = if (gameViewModel.darkOnOrOff) {
                    gameViewModel.appColors[4]
                } else gameViewModel.appColors[3]
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = bgColor
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Menu.route
                    ) {
                        composable(Routes.Menu.route) { Menu(navigationController, gameViewModel) }
                        composable(Routes.Game.route) { Game(navigationController, gameViewModel) }
                        composable(Routes.Result.route) {
                            Result(
                                navigationController,
                                gameViewModel
                            )
                        }
                        composable(Routes.Settings.route) {
                            Settings(
                                navigationController,
                                gameViewModel
                            )
                        }
                    }

                }
            }
        }

    }


}




