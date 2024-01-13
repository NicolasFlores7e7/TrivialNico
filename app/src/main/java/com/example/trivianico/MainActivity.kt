package com.example.trivianico

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trivianico.ui.theme.TriviaNicoTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaNicoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(146, 193, 220, 255)
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Menu.route
                    ) {
                        composable(Routes.Menu.route){ Menu(navigationController) }
                        composable(Routes.Game.route){ Game(navigationController) }
                        composable(Routes.Result.route){ Result(navigationController) }
                        composable(Routes.Settings.route){ Settings(navigationController) }
                    }
                }
            }
        }
    }
}

