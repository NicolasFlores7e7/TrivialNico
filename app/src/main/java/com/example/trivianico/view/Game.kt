package com.example.trivianico.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivianico.R
import com.example.trivianico.model.questionsList
import com.example.trivianico.navigation.Routes
import com.example.trivianico.viewModel.GameViewModel


@Composable
fun Game(navController: NavController, gameViewModel: GameViewModel) {
    val fonts = gameViewModel.fonts

    var buttonColors = gameViewModel.buttonColors

    if (gameViewModel.gameOver) {
        navController.navigate(Routes.Result.route)
    }

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
            color = Color(0xFF01224C)
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
            text = questionsList[gameViewModel.random].category.toString(),
            fontSize = 32.sp,
            fontFamily = fonts,
            fontWeight = FontWeight.Light,
            color = Color(0xFF01224C),
        )
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier
                    .fillMaxWidth(0.8f),
                text = questionsList[gameViewModel.random].question,
                fontSize = 16.sp,
                fontFamily = fonts,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                color = Color(0xFF01224C),
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
            ) {
                Button(
                    onClick = {
                        gameViewModel.checkIfCorrect(gameViewModel.randomPositionsShuffled[0])
                        gameViewModel.stopCountdown()
                        gameViewModel.startCountdown()
                    },
                    modifier = Modifier
                        .width(160.dp)
                        .height(80.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = buttonColors[0],
                        contentColor = Color(0xFF01224C),
                        disabledContainerColor = buttonColors[gameViewModel.buttonColorsChanger]

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
                        gameViewModel.stopCountdown()
                        gameViewModel.startCountdown()
                    },
                    modifier = Modifier
                        .width(160.dp)
                        .height(80.dp),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = buttonColors[0],
                        contentColor = Color(0xFF01224C),
                        disabledContainerColor = buttonColors[gameViewModel.buttonColorsChanger]
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
                        gameViewModel.stopCountdown()
                        gameViewModel.startCountdown()
                    },
                    modifier = Modifier
                        .width(160.dp)
                        .height(80.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = buttonColors[0],
                        contentColor = Color(0xFF01224C),
                        disabledContainerColor = buttonColors[gameViewModel.buttonColorsChanger]
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
                        gameViewModel.stopCountdown()
                        gameViewModel.startCountdown()
                    },
                    modifier = Modifier
                        .width(160.dp)
                        .height(80.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = buttonColors[0],
                        contentColor = Color(0xFF01224C),
                        disabledContainerColor = buttonColors[gameViewModel.buttonColorsChanger]
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
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(16.dp)
                    .clip(
                        RoundedCornerShape(16.dp)
                    ),
                progress = gameViewModel.progress,
                color = Color(0xFF01224C),
            )
            Text(
                text = "${gameViewModel.chosenTime}",
                fontFamily = fonts,
                fontSize = 24.sp,
                color = Color(0xFF01224C)
            )
        }
    }




}


