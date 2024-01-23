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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivianico.R
import com.example.trivianico.model.questionsList
import com.example.trivianico.viewModel.GameViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Game(navController: NavController, gameViewModel: GameViewModel) {
    val fonts = gameViewModel.fonts
    val random by remember { mutableStateOf((questionsList.indices).random()) }
    val randomPositions = listOf(
        questionsList[random].correctOption,
        questionsList[random].incorrectOption1,
        questionsList[random].incorrectOption2,
        questionsList[random].incorrectOption3
    )
    var randomPositionsSuffled by remember {
        mutableStateOf(randomPositions.shuffled())
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
                .padding(top = 32.dp),
            painter = painterResource(id = R.drawable.ic_geo),
            contentDescription = "Icono tema",
        )
        Text(
            text = questionsList[random].category.toString(),
            fontSize = 32.sp,
            fontFamily = fonts,
            fontWeight = FontWeight.Light,
            color = Color(0xFF01224C),
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Spacer(modifier = Modifier.height(80.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            text = questionsList[random].question,
            fontSize = 16.sp,
            fontFamily = fonts,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            color = Color(0xFF01224C),
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(160.dp)
                    .height(80.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFDAE6F2),
                    contentColor = Color(0xFF01224C)
                ),
                shape = RectangleShape
            ) {
                Text(
                    text = randomPositionsSuffled[0],
                    fontSize = 16.sp,
                    fontFamily = fonts,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.width(24.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(160.dp)
                    .height(80.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFDAE6F2),
                    contentColor = Color(0xFF01224C)
                ),
                shape = RectangleShape
            ) {
                Text(
                    text = randomPositionsSuffled[1],
                    fontSize = 16.sp,
                    fontFamily = fonts,
                    textAlign = TextAlign.Center
                )
            }

        }
        Spacer(modifier = Modifier.height(32.dp))
        Row {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(160.dp)
                    .height(80.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFDAE6F2),
                    contentColor = Color(0xFF01224C)
                ),
                shape = RectangleShape
            ) {
                Text(
                    text = randomPositionsSuffled[2],
                    fontSize = 16.sp,
                    fontFamily = fonts,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(160.dp)
                    .height(80.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFDAE6F2),
                    contentColor = Color(0xFF01224C)
                ),
                shape = RectangleShape
            ) {
                Text(
                    text = randomPositionsSuffled[3],
                    fontSize = 16.sp,
                    fontFamily = fonts,
                    textAlign = TextAlign.Center
                )
            }
        }

    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp),
        verticalArrangement = Arrangement.Bottom,
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


