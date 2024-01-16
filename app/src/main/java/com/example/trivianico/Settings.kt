package com.example.trivianico

import android.graphics.drawable.VectorDrawable
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Settings(navController: NavController) {
    val fonts = FontFamily(
        Font(R.font.josefinsans_regular)
    )

    Column(
        modifier = Modifier
            .fillMaxSize(0.9f)
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyExposedDropdownMenu(fonts)
        Spacer(modifier = Modifier.height(32.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically){
            Text(text = "Rounds: ",
                fontFamily = fonts,
                fontSize = 24.sp,
                color = Color(0xFF01224C)
                )
            MyRadioButtons()
        }
        SliderMinimalExample()

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExposedDropdownMenu(fonts: FontFamily) {
    val difficulty = listOf("Easy", "Normal", "Hard")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(difficulty[0]) }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },

        ) {
        TextField(
            modifier = Modifier
                .menuAnchor()
                .border(
                    border = BorderStroke(
                        width = 4.dp,
                        color = Color(0xFF01224C),

                        ),
                    shape = RoundedCornerShape(50)
                ),
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
                textColor = Color(0xFF01224C),
                containerColor = Color(0x6101224C)),
            shape = RoundedCornerShape(50),
            leadingIcon = {
                Icon(
                    painterResource(id = R.drawable.ic_difficulty,),
                    contentDescription = null,
                )
            }

        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            difficulty.forEach { selectionOption ->
                DropdownMenuItem(
                    text = {
                        Text(
                            selectionOption,
                            fontFamily = fonts,
                            fontSize = 24.sp,
                            color = Color(0xFF01224C)
                        )
                    },
                    onClick = {
                        selectedText = selectionOption
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,

                    )
            }
        }
    }
}

@Composable
fun MyRadioButtons(){
    val radioOptions = listOf("5","10","15")
    var selectedOption by remember { mutableStateOf(radioOptions[0]) }
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        radioOptions.forEach { fruitName ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = (fruitName == selectedOption),
                    onClick = { selectedOption = fruitName }
                )
                Text(
                    text = fruitName,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }

    }
}

@Composable
fun SliderMinimalExample() {
    var sliderPosition by remember { mutableFloatStateOf(0.5f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
        Text(text = sliderPosition.toString())
    }
}