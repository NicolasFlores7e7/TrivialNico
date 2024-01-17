package com.example.trivianico.view


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivianico.navigation.Routes
import com.example.trivianico.R
import com.example.trivianico.viewModel.MyViewModel
import com.example.trivianico.viewModel.Setting


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Menu(navController: NavController, myViewModel: MyViewModel, settings: Setting) {
    val fonts = myViewModel.fonts
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_app),
            contentDescription = "Icono"
        )
        ElevatedButton(
            onClick = { navController.navigate(Routes.Game.route) },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFDAE6F2),
                contentColor = Color(0xFF01224C)
            ),
            shape = RectangleShape
        ) {
            Icon(
                painterResource(id = R.drawable.ic_play),
                contentDescription = "icon",

                )

            Text(
                text = "Play",
                fontSize = 24.sp,
                fontFamily = fonts,
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        ElevatedButton(
            onClick = { navController.navigate(Routes.Settings.route) },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFDAE6F2),
                contentColor = Color(0xFF01224C)
            ),
            shape = RectangleShape
        ) {
            Icon(
                painterResource(id = R.drawable.ic_settings),
                contentDescription = "icon",
            )
            Text(
                text = "Settings",
                fontSize = 24.sp,
                fontFamily = fonts,

                )
        }
    }
}