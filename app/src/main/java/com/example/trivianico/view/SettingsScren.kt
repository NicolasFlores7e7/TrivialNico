package com.example.trivianico.view

import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trivianico.navigation.Routes
import com.example.trivianico.R
import com.example.trivianico.viewModel.GameViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Settings(navController: NavController, gameViewModel: GameViewModel) {

    val fonts = gameViewModel.fonts
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
            BoxWithConstraints (
                modifier = Modifier
                    .fillMaxSize(0.9f),
            ){
                Spacer(Modifier.height(16.dp))
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = "Settings",
                        fontFamily = fonts,
                        fontSize = 32.sp,
                        color = fontColor
                        )
                }
                Spacer(Modifier.height(24.dp))
                Row(
                    modifier = Modifier
                        .padding(
                            start = 64.dp,
                            top = 32.dp),
                    ){
                    Column(
                        modifier = Modifier
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Spacer(Modifier.height(32.dp))
                        MyExposedDropdownMenu(fonts, gameViewModel, fontColor, containerColor)
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Text(
                                text = "Rounds: ",
                                fontFamily = fonts,
                                fontSize = 24.sp,
                                color = fontColor
                            )
                            Spacer(modifier = Modifier.width(32.dp))
                            MyRadioButtons(fonts, gameViewModel, fontColor)
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize(0.9f)
                            .padding(top = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        MySlider(fonts, gameViewModel, fontColor)
                        Spacer(Modifier.height(16.dp))
                        Row(verticalAlignment = Alignment.CenterVertically)
                        {
                            Text(
                                text = "Dark Mode",
                                fontFamily = fonts,
                                fontSize = 24.sp,
                                color = fontColor
                            )
                            Spacer(modifier = Modifier.width(32.dp))
                            MySwitch(gameViewModel)
                        }
                        Spacer(Modifier.height(16.dp))
                        ElevatedButton(
                            onClick = {
                                navController.navigate(Routes.Menu.route)
                                navController.clearBackStack("menu")
                            },
                            modifier = Modifier
                                .fillMaxWidth(0.8f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = containerColor,
                                contentColor = fontColor
                            ),
                            shape = RectangleShape,
                        ) {
                            Icon(
                                painterResource(id = R.drawable.ic_menu),
                                contentDescription = "icon",
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Return to menu",
                                fontSize = 24.sp,
                                fontFamily = fonts,

                                )
                        }
                    }

                }

            }

        }

        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize(0.9f)
                    .padding(top = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Settings",
                    fontFamily = fonts,
                    fontSize = 32.sp,
                    color = fontColor
                )
                Spacer(modifier = Modifier.height(32.dp))
                MyExposedDropdownMenu(fonts, gameViewModel, fontColor, containerColor)
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Text(
                        text = "Rounds: ",
                        fontFamily = fonts,
                        fontSize = 24.sp,
                        color = fontColor
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    MyRadioButtons(fonts, gameViewModel, fontColor)
                }
                MySlider(fonts, gameViewModel, fontColor)
                Spacer(modifier = Modifier.height(32.dp))
                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Text(
                        text = "Dark Mode",
                        fontFamily = fonts,
                        fontSize = 24.sp,
                        color = fontColor
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    MySwitch(gameViewModel)

                }
                Spacer(modifier = Modifier.height(32.dp))
                ElevatedButton(
                    onClick = {
                        navController.navigate(Routes.Menu.route)
                        navController.clearBackStack("menu")
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = containerColor,
                        contentColor = fontColor
                    ),
                    shape = RectangleShape,
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_menu),
                        contentDescription = "icon",
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Return to menu",
                        fontSize = 24.sp,
                        fontFamily = fonts,

                        )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExposedDropdownMenu(
    fonts: FontFamily,
    gameViewModel: GameViewModel,
    fontColor: Color,
    containerColor: Color
) {
    val difficulty = listOf("Easy", "Normal", "Hard")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(difficulty[0]) }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },

        ) {
        TextField(
            modifier = Modifier
                .menuAnchor(),
            textStyle = TextStyle(
                fontFamily = fonts,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            ),
            readOnly = true,
            value = selectedText,
            onValueChange = { selectedText = it },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                textColor = fontColor,
                containerColor = containerColor
            ),
            shape = RectangleShape,
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            difficulty.forEach { selectionOption ->
                DropdownMenuItem(
                    modifier = Modifier
                        .background(containerColor),
                    text = {
                        Text(
                            selectionOption,
                            fontFamily = fonts,
                            fontSize = 24.sp,
                            color = fontColor
                        )
                    },
                    onClick = {
                        selectedText = selectionOption
                        expanded = false
                        gameViewModel.changeDif(selectedText)
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,

                    )
            }
        }
    }

}

@Composable
fun MyRadioButtons(fonts: FontFamily, gameViewModel: GameViewModel, fontColor: Color) {
    val radioOptions = listOf("5", "10", "15")
    var selectedOption by remember { mutableStateOf(radioOptions[0]) }
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        radioOptions.forEach { option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = {
                        selectedOption = option
                        gameViewModel.changeRounds(selectedOption.toInt())
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = fontColor,
                        unselectedColor = Color(0x4001224C)
                    )
                )
                Text(
                    text = option,
                    fontSize = 24.sp,
                    fontFamily = fonts,
                    color = fontColor
                )
            }
        }

    }

}


@Composable
fun MySlider(fonts: FontFamily, gameViewModel: GameViewModel, fontColor: Color) {
    var sliderPosition by remember { mutableFloatStateOf(0.5f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
                gameViewModel.changeTime((sliderPosition * 15).toInt())
                println((gameViewModel.chosenTime))
            },
            colors = SliderDefaults.colors(
                thumbColor = fontColor,
                activeTrackColor = fontColor,
                inactiveTrackColor = Color(0x4001224C)
            )
        )
        Text(
            text = "${(sliderPosition * 15).toInt()} seconds per round.",
            fontFamily = fonts,
            fontSize = 24.sp,
            color = fontColor
        )

    }
}

@Composable
fun MySwitch(gameViewModel: GameViewModel) {
    var checked by remember { mutableStateOf(false) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
            gameViewModel.changeDarkMode(checked)
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color(0xFFDAE6F2),
            checkedTrackColor = Color(0x4001224C),
            uncheckedThumbColor = Color(0xFFDAE6F2),
            uncheckedTrackColor = Color(0x4001224C)
        ),

        )

}
