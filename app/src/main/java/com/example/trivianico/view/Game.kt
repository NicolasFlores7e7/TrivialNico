package com.example.trivianico.view

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivianico.navigation.Routes
import com.example.trivianico.viewModel.GameViewModel
import kotlinx.coroutines.delay


@Composable
fun Game(navController: NavController, gameViewModel: GameViewModel) {
    val fonts = gameViewModel.fonts
    if (gameViewModel.gameOver) {
        navController.navigate(Routes.Result.route)
    }
    var timeLeft by rememberSaveable { mutableIntStateOf(gameViewModel.remainingTime) }
    var configuration = LocalConfiguration.current
    var fontColor by remember { mutableStateOf(gameViewModel.appColors[5]) }
    fontColor = if (gameViewModel.darkOnOrOff) {
        gameViewModel.appColors[0]
    } else gameViewModel.appColors[5]
    var containerColor by remember { mutableStateOf(gameViewModel.appColors[0]) }
    containerColor = if (gameViewModel.darkOnOrOff) {
        gameViewModel.appColors[5]
    } else gameViewModel.appColors[0]

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize(0.9f)
            ) {
                Row {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(start = 16.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier,
                            text = "Ronda ${gameViewModel.roundsCounter}/${gameViewModel.chosenRounds}",
                            fontSize = 24.sp,
                            fontFamily = fonts,
                            fontWeight = FontWeight.Light,
                            color = fontColor
                        )
                        Image(
                            modifier = Modifier
                                .padding(
                                    top = 32.dp,
                                ),
                            painter = painterResource(
                                id = gameViewModel.imageList[gameViewModel.imageListSelector]
                            ),
                            contentDescription = "Icono tema",
                            contentScale = ContentScale.Inside
                        )
                        Text(
                            modifier = Modifier,
                            text = gameViewModel.questionDiffListNumber[gameViewModel.diffNumber][gameViewModel.random].category.toString(),
                            fontSize = 32.sp,
                            fontFamily = fonts,
                            fontWeight = FontWeight.Light,
                            color = fontColor,
                        )
                    }
                    Spacer(modifier = Modifier.width(32.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(start = 16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(0.7f),
                            text = gameViewModel.questionDiffListNumber[gameViewModel.diffNumber][gameViewModel.random].question,
                            fontSize = 24.sp,
                            fontFamily = fonts,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center,
                            color = fontColor,
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Row(modifier = Modifier
                            .fillMaxWidth()
                        ) {
                            Button(
                                onClick = {
                                    gameViewModel.checkIfCorrect(gameViewModel.randomPositionsShuffled[0])
                                    gameViewModel.roundsFinish()
                                    gameViewModel.buttonsEnabler = false
                                },
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(80.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = containerColor,
                                    contentColor = fontColor,
                                    disabledContainerColor = gameViewModel.appColors[gameViewModel.buttonColorsChangerWhenPressed[0].value]

                                ),
                                shape = RectangleShape,
                                enabled = gameViewModel.buttonsEnabler,
                            ) {
                                Text(
                                    text = gameViewModel.randomPositionsShuffled[0],
                                    fontSize = 12.sp,
                                    fontFamily = fonts,
                                    textAlign = TextAlign.Center
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Button(
                                onClick = {
                                    gameViewModel.checkIfCorrect(gameViewModel.randomPositionsShuffled[1])
                                    gameViewModel.roundsFinish()
                                    gameViewModel.buttonsEnabler = false
                                },
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(80.dp),

                                colors = ButtonDefaults.buttonColors(
                                    containerColor = containerColor,
                                    contentColor = fontColor,
                                    disabledContainerColor = gameViewModel.appColors[gameViewModel.buttonColorsChangerWhenPressed[1].value]
                                ),
                                shape = RectangleShape,
                                enabled = gameViewModel.buttonsEnabler,
                            ) {
                                Text(
                                    text = gameViewModel.randomPositionsShuffled[1],
                                    fontSize = 12.sp,
                                    fontFamily = fonts,
                                    textAlign = TextAlign.Center
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Button(
                                onClick = {
                                    gameViewModel.checkIfCorrect(gameViewModel.randomPositionsShuffled[2])
                                    gameViewModel.roundsFinish()
                                    gameViewModel.buttonsEnabler = false
                                },
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(80.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = containerColor,
                                    contentColor = fontColor,
                                    disabledContainerColor = gameViewModel.appColors[gameViewModel.buttonColorsChangerWhenPressed[2].value]
                                ),
                                shape = RectangleShape,
                                enabled = gameViewModel.buttonsEnabler,
                            ) {
                                Text(
                                    text = gameViewModel.randomPositionsShuffled[2],
                                    fontSize = 12.sp,
                                    fontFamily = fonts,
                                    textAlign = TextAlign.Center
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Button(
                                onClick = {
                                    gameViewModel.checkIfCorrect(gameViewModel.randomPositionsShuffled[3])
                                    gameViewModel.roundsFinish()
                                    gameViewModel.buttonsEnabler = false
                                },
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(80.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = containerColor,
                                    contentColor = fontColor,
                                    disabledContainerColor = gameViewModel.appColors[gameViewModel.buttonColorsChangerWhenPressed[3].value]
                                ),
                                shape = RectangleShape,
                                enabled = gameViewModel.buttonsEnabler,
                            ) {
                                Text(
                                    text = gameViewModel.randomPositionsShuffled[3],
                                    fontSize = 12.sp,
                                    fontFamily = fonts,
                                    textAlign = TextAlign.Center
                                )
                            }

                        }
                        Spacer(Modifier.height(32.dp))
                        LaunchedEffect(timeLeft) {
                            gameViewModel.imageSelector()
                            while (timeLeft > 0) {
                                delay(1000L)
                                timeLeft--
                                println("valor de dark: ${gameViewModel.darkOnOrOff}")

                            }
                            if (timeLeft == 0) {
                                gameViewModel.roundsFinish()
                                delay(2000L)
                                gameViewModel.roundsPlusOne()
                                timeLeft = gameViewModel.remainingTime
                            }
                        }
                        Column(

                            modifier = Modifier
                                .fillMaxWidth(0.8f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            LinearProgressIndicator(
                                progress = timeLeft.toFloat() / gameViewModel.chosenTime,
                                color = fontColor,
                                trackColor = containerColor

                            )
                            Spacer(Modifier.height(8.dp))
                            Text(
                                text = "$timeLeft",
                                color = fontColor
                            )
                        }
                    }
                }

            }

        }

        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 40.dp),
                    text = "Ronda ${gameViewModel.roundsCounter}/${gameViewModel.chosenRounds}",
                    fontSize = 24.sp,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Light,
                    color = fontColor
                )
                Image(
                    modifier = Modifier
                        .padding(
                            top = 32.dp,
                        ),
                    painter = painterResource(
                        id = gameViewModel.imageList[gameViewModel.imageListSelector]
                    ),
                    contentDescription = "Icono tema",
                    contentScale = ContentScale.Inside
                )
                Text(
                    text = gameViewModel.questionDiffListNumber[gameViewModel.diffNumber][gameViewModel.random].category.toString(),
                    fontSize = 32.sp,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Light,
                    color = fontColor
                )
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        modifier = Modifier
                            .fillMaxWidth(0.8f),
                        text = gameViewModel.questionDiffListNumber[gameViewModel.diffNumber][gameViewModel.random].question,
                        fontSize = 16.sp,
                        fontFamily = fonts,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center,
                        color = fontColor
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                    ) {
                        Button(
                            onClick = {
                                gameViewModel.checkIfCorrect(gameViewModel.randomPositionsShuffled[0])
                                gameViewModel.roundsFinish()
                                gameViewModel.buttonsEnabler = false
                            },
                            modifier = Modifier
                                .width(160.dp)
                                .height(80.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = containerColor,
                                contentColor = fontColor,
                                disabledContainerColor = gameViewModel.appColors[gameViewModel.buttonColorsChangerWhenPressed[0].value]

                            ),
                            shape = RectangleShape,
                            enabled = gameViewModel.buttonsEnabler,
                        ) {
                            Text(
                                text = gameViewModel.randomPositionsShuffled[0],
                                fontSize = 16.sp,
                                fontFamily = fonts,
                                textAlign = TextAlign.Center
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            onClick = {
                                gameViewModel.checkIfCorrect(gameViewModel.randomPositionsShuffled[1])
                                gameViewModel.roundsFinish()
                                gameViewModel.buttonsEnabler = false
                            },
                            modifier = Modifier
                                .width(160.dp)
                                .height(80.dp),

                            colors = ButtonDefaults.buttonColors(
                                containerColor = containerColor,
                                contentColor = fontColor,
                                disabledContainerColor = gameViewModel.appColors[gameViewModel.buttonColorsChangerWhenPressed[1].value]
                            ),
                            shape = RectangleShape,
                            enabled = gameViewModel.buttonsEnabler,
                        ) {
                            Text(
                                text = gameViewModel.randomPositionsShuffled[1],
                                fontSize = 16.sp,
                                fontFamily = fonts,
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row {
                        Button(
                            onClick = {
                                gameViewModel.checkIfCorrect(gameViewModel.randomPositionsShuffled[2])
                                gameViewModel.roundsFinish()
                                gameViewModel.buttonsEnabler = false
                            },
                            modifier = Modifier
                                .width(160.dp)
                                .height(80.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = containerColor,
                                contentColor = fontColor,
                                disabledContainerColor = gameViewModel.appColors[gameViewModel.buttonColorsChangerWhenPressed[2].value]
                            ),
                            shape = RectangleShape,
                            enabled = gameViewModel.buttonsEnabler,
                        ) {
                            Text(
                                text = gameViewModel.randomPositionsShuffled[2],
                                fontSize = 16.sp,
                                fontFamily = fonts,
                                textAlign = TextAlign.Center
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))

                        Button(
                            onClick = {
                                gameViewModel.checkIfCorrect(gameViewModel.randomPositionsShuffled[3])
                                gameViewModel.roundsFinish()
                                gameViewModel.buttonsEnabler = false
                            },
                            modifier = Modifier
                                .width(160.dp)
                                .height(80.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = containerColor,
                                contentColor = fontColor,
                                disabledContainerColor = gameViewModel.appColors[gameViewModel.buttonColorsChangerWhenPressed[3].value]
                            ),
                            shape = RectangleShape,
                            enabled = gameViewModel.buttonsEnabler,
                        ) {
                            Text(
                                text = gameViewModel.randomPositionsShuffled[3],
                                fontSize = 16.sp,
                                fontFamily = fonts,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                }
                Spacer(modifier = Modifier.height(16.dp))
                LaunchedEffect(timeLeft) {
                    gameViewModel.imageSelector()
                    while (timeLeft > 0) {
                        delay(1000L)
                        timeLeft--

                    }
                    if (timeLeft == 0) {
                        gameViewModel.roundsFinish()
                        delay(2000L)
                        gameViewModel.roundsPlusOne()
                        timeLeft = gameViewModel.remainingTime
                    }
                }
                Column(

                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LinearProgressIndicator(
                        progress = timeLeft.toFloat() / gameViewModel.chosenTime,
                        color = fontColor,
                        trackColor = containerColor
                    )
                    Text(
                        text = "$timeLeft",
                        color = fontColor
                    )
                }
            }
        }
    }


}




