package com.example.trivianico.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivianico.R
import com.example.trivianico.navigation.Routes
import com.example.trivianico.viewModel.GameViewModel

@Composable
fun Result(navController: NavController, gameViewModel: GameViewModel) {
    val fonts = gameViewModel.fonts
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
        )
        Spacer(modifier = Modifier.height(16.dp))
        ElevatedButton(
            onClick = {           },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFDAE6F2),
                contentColor = Color(0xFF01224C)
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
                containerColor = Color(0xFFDAE6F2),
                contentColor = Color(0xFF01224C)
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