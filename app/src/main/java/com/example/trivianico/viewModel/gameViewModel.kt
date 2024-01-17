package com.example.trivianico.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.ViewModel
import com.example.trivianico.R
import java.sql.Time

class MyViewModel: ViewModel() {
    val fonts = FontFamily(
        Font(R.font.josefinsans_regular)
    )
    var chosenTime = 7

    fun changeTime(time: Int){
        chosenTime = time
    }


}

