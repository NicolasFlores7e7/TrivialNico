package com.example.trivianico.viewModel


import androidx.activity.OnBackPressedCallback
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import com.example.trivianico.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    val fonts = FontFamily(
        Font(R.font.josefinsans_regular)
    )

    var chosenDif = "Easy"
    var chosenRounds = 5
    var chosenTime = 7
    var darkOnOrOff = false
    var roundsCounter = 1
    private val mainScope = MainScope()
    var progress by mutableStateOf(1f)
        private set
    var remainingTime by mutableStateOf(chosenTime)
        private set

    fun changeDif(dif: String) {
        chosenDif = dif
    }

    fun changeRounds(rounds: Int) {
        chosenRounds = rounds
    }

    fun changeTime(time: Int) {
        chosenTime = time

    }

    fun changeDarkMode(onOrOff: Boolean) {
        darkOnOrOff = onOrOff
    }


    fun startCountdown() {
        mainScope.launch {
            val minus = 1f / chosenTime
            for (i in remainingTime  downTo 0) {
                changeTime(i)
                progress -= minus
                delay(1000)
                println("remainig time "+remainingTime)
                println("chosen time "+ chosenTime)

                if (i == 0) {
                    changeTime(remainingTime)
                }
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        mainScope.cancel()
    }
}



