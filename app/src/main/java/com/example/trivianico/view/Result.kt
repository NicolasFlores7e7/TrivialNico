package com.example.trivianico.view

import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.example.trivianico.R
import com.example.trivianico.navigation.Routes
import com.example.trivianico.viewModel.GameViewModel

@Composable
fun Result(navController: NavController, gameViewModel: GameViewModel) {
    val fonts = gameViewModel.fonts
    val context = LocalContext.current
    val text = "Mira mi puntuación en este juego de trivia"
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT,text)
    }
    val shareIntent = Intent.createChooser(sendIntent,"Share with...")
    var fontColor by remember { mutableStateOf(gameViewModel.appColors[5]) }
    fontColor = if (gameViewModel.darkOnOrOff) {
        gameViewModel.appColors[0]
    } else gameViewModel.appColors[5]
    var containerColor by remember { mutableStateOf(gameViewModel.appColors[0]) }
    containerColor = if (gameViewModel.darkOnOrOff) {
        gameViewModel.appColors[5]
    } else gameViewModel.appColors[0]

    var configuration = LocalConfiguration.current

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize(0.8f)
                    .padding(top = 32.dp),
            ){
                Row(
                    modifier = Modifier
                        .fillMaxHeight(0.8f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(modifier = Modifier
                        .fillMaxHeight()) {
                        Image(

                            painter = painterResource(id = R.drawable.ic_app),
                            contentDescription = "Icono"
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxHeight(0.9f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight(0.8f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Puntuacion : ${gameViewModel.correct} puntos",
                                fontSize = 32.sp,
                                fontFamily = fonts,
                                textAlign = TextAlign.Center,
                                color = fontColor
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            ElevatedButton(
                                onClick = {
                                    startActivity(context, shareIntent, null)
                                },
                                modifier = Modifier
                                    .fillMaxWidth(0.8f),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = containerColor,
                                    contentColor = fontColor
                                ),
                                shape = RectangleShape
                            ) {
                                Icon(
                                    painterResource(id = R.drawable.ic_share),
                                    contentDescription = "icon",

                                    )
                                Spacer(modifier = Modifier.width(16.dp))
                                Text(
                                    text = "Share",
                                    fontSize = 24.sp,
                                    fontFamily = fonts,
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            ElevatedButton(
                                onClick = {
                                    navController.navigate(Routes.Menu.route)
                                },
                                modifier = Modifier
                                    .fillMaxWidth(0.8f),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = containerColor,
                                    contentColor = fontColor
                                ),
                                shape = RectangleShape
                            ) {
                                Icon(
                                    painterResource(id = R.drawable.ic_menu),
                                    contentDescription = "icon",

                                    )
                                Spacer(modifier = Modifier.width(16.dp))
                                Text(
                                    text = "Return to main menu",
                                    fontSize = 24.sp,
                                    fontFamily = fonts,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }

                }
            }
        }
        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 80.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_app),
                    contentDescription = "Icono"
                )
                Text(
                    text = "Puntuacion : ${gameViewModel.correct} puntos",
                    fontSize = 32.sp,
                    fontFamily = fonts,
                    textAlign = TextAlign.Center,
                    color = fontColor
                )
                Spacer(modifier = Modifier.height(16.dp))
                ElevatedButton(
                    onClick = {
                        startActivity(context, shareIntent, null)
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = containerColor,
                        contentColor = fontColor
                    ),
                    shape = RectangleShape
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_share),
                        contentDescription = "icon",

                        )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Share",
                        fontSize = 24.sp,
                        fontFamily = fonts,
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                ElevatedButton(
                    onClick = {
                        navController.navigate(Routes.Menu.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = containerColor,
                        contentColor = fontColor
                    ),
                    shape = RectangleShape
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_menu),
                        contentDescription = "icon",

                        )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Return to main menu",
                        fontSize = 24.sp,
                        fontFamily = fonts,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }



}