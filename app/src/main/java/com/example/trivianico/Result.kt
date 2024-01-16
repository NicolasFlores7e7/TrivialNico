package com.example.trivianico

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Result(navController: NavController) {
    val fonts = FontFamily(
        Font(R.font.josefinsans_regular)
    )
    Column(
        modifier = Modifier
            .fillMaxSize(0.9f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Your Score",
            fontSize = 32.sp,
            fontFamily = fonts,
            modifier = Modifier
                .padding(bottom = 160.dp))
        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFDAE6F2),
                contentColor = Color(0xFF01224C)
            )
            ) {
            Text(text = "Share",
                fontSize = 24.sp,
                fontFamily = fonts,

                )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { navController.navigate(Routes.Menu.route)},
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFDAE6F2),
                contentColor = Color(0xFF01224C)
            )
            ) {
            Text(text = "Return to main menu",
                fontSize = 24.sp,
                fontFamily = fonts,
                )
        }
    }

}