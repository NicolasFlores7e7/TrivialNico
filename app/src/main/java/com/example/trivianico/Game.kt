package com.example.trivianico

import android.graphics.Paint.Style
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.math.round

@Composable
fun Game(navController: NavController) {
    val fonts = FontFamily(
        Font(R.font.josefinsans_regular)
    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(top = 40.dp),
            text = "Ronda 1/10",
            fontSize = 24.sp,
            fontFamily = fonts,
            fontWeight = FontWeight.Light
        )
        Image(
            modifier = Modifier
                .padding(top = 80.dp),
            painter = painterResource(id = R.drawable.ic_geo),
            contentDescription = "Icono tema",
        )
        Text(
            text = "Geografía",
            fontSize = 32.sp,
            fontFamily = fonts,
            fontWeight = FontWeight.Light,
            color = Color(0xFF01224C),
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "¿Cuál es la capital de Suecia?",
            fontSize = 16.sp,
            fontFamily = fonts,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF01224C),
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(160.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFDAE6F2),
                    contentColor = Color(0xFF01224C)
                )
            ) {
                Text(text = "Estocolmo",
                    fontSize = 24.sp,
                    fontFamily = fonts,)
            }
            Spacer(modifier = Modifier.width(24.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(160.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFDAE6F2),
                    contentColor = Color(0xFF01224C)
                )
            ) {
                Text(text = "Paris",
                    fontSize = 24.sp,
                    fontFamily = fonts,)
            }

        }
        Spacer(modifier = Modifier.height(32.dp))
        Row {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(160.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFDAE6F2),
                    contentColor = Color(0xFF01224C)
                )
            ) {
                Text(text = "Madrid",
                    fontSize = 24.sp,
                    fontFamily = fonts,)
            }
            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(160.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFDAE6F2),
                    contentColor = Color(0xFF01224C)
                )
            ) {
                Text(text = "Konoha",
                    fontSize = 24.sp,
                    fontFamily = fonts,)
            }
        }

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 160.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
    LinearProgressIndicator(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(16.dp)
            .clip(
                RoundedCornerShape(16.dp)),
        progress = 0.5f,
        color = Color(0xFF01224C),
    )
    }
}