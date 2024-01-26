package com.example.trivianico.viewModel


import androidx.activity.OnBackPressedCallback
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import com.example.trivianico.R
import com.example.trivianico.model.Questions
import com.example.trivianico.model.questionsList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    val fonts = FontFamily(
        Font(R.font.josefinsans_regular)
    )

    var chosenDif by mutableStateOf("Easy")
    var chosenRounds by mutableIntStateOf(5)
    var chosenTime by mutableIntStateOf(7)
    var darkOnOrOff by mutableStateOf(false)
    var roundsCounter by mutableIntStateOf(1)
    var correct by mutableStateOf(0)
    private val mainScope = MainScope()
    var progress by mutableFloatStateOf(1.1f)
        private set
    var remainingTime by mutableIntStateOf(chosenTime)
        private set

    var random = questionsList.indices.random()

    var randomPositions by mutableStateOf(
        listOf(
            questionsList[random].correctOption,
            questionsList[random].incorrectOption1,
            questionsList[random].incorrectOption2,
            questionsList[random].incorrectOption3
        )
    )

    var randomPositionsShuffled by mutableStateOf(randomPositions.shuffled())

    private var countdownJob: Job? = null


    fun questionRandomizer() {
        random = questionsList.indices.random()
        randomPositions = listOf(
            questionsList[random].correctOption,
            questionsList[random].incorrectOption1,
            questionsList[random].incorrectOption2,
            questionsList[random].incorrectOption3
        )
        randomPositionsShuffled = randomPositions.shuffled()
    }

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
        countdownJob?.cancel()
       countdownJob = mainScope.launch {
            val minus = 1f / chosenTime
            for (i in remainingTime downTo 0) {
                changeTime(i)
                progress -= minus
                delay(1000)
                if (i == 0) {
                    changeTime(remainingTime)
                    progress = 1.1f
                    roundsCounter++
                    questionRandomizer()
                    startCountdown()

                }
                if (roundsCounter>=5) onCleared()

            }
        }

    }
    fun stopCountdown() {
        countdownJob?.cancel()
    }

    override fun onCleared() {
        super.onCleared()
        mainScope.cancel()
    }


    fun checkIfCorrect(option: String) {
        var itIsCorrect = false
        if (option == questionsList[random].correctOption) {
            correct++
        }
        println(correct)
    }

}







