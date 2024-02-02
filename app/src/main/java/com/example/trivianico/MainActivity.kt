package com.example.trivianico

import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trivianico.ui.theme.TriviaNicoTheme
import com.example.trivianico.view.Game
import com.example.trivianico.view.Menu
import com.example.trivianico.view.Result
import com.example.trivianico.navigation.Routes
import com.example.trivianico.view.Settings
import com.example.trivianico.viewModel.GameViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameViewModel: GameViewModel by viewModels()



        setContent {
            TriviaNicoTheme {
                var bgColor by remember { mutableStateOf(gameViewModel.appColors[3])}
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = bgColor
                ) {
                    if (gameViewModel.darkOnOrOff) {
                        bgColor = gameViewModel.appColors[4]
                    }else bgColor = gameViewModel.appColors[3]
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




