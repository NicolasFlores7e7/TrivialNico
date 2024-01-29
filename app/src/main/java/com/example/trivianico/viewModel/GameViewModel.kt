package com.example.trivianico.viewModel


import androidx.activity.OnBackPressedCallback
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import com.example.trivianico.R
import com.example.trivianico.model.Category
import com.example.trivianico.model.Questions
import com.example.trivianico.model.questionsList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class GameViewModel : ViewModel() {
    val fonts = FontFamily(
        Font(R.font.josefinsans_regular)
    )

    private var chosenDif by mutableStateOf("Easy")
    var chosenRounds by mutableIntStateOf(5)
    var chosenTime by mutableIntStateOf(7)
    private var darkOnOrOff by mutableStateOf(false)
    var roundsCounter by mutableIntStateOf(1)
    var correct by mutableIntStateOf(0)
    private val mainScope = MainScope()
    var progress by mutableFloatStateOf(1f)
        private set
    private var remainingTime by mutableIntStateOf(chosenTime)
        private set

    var random = questionsList.indices.random()

    private var randomPositions by mutableStateOf(
        listOf(
            questionsList[random].correctOption,
            questionsList[random].incorrectOption1,
            questionsList[random].incorrectOption2,
            questionsList[random].incorrectOption3
        )
    )
    var randomPositionsShuffled by mutableStateOf(randomPositions.shuffled())

    var buttonColors = listOf(
        Color(0xFFDAE6F2),
        Color(0xB2FF8181),
        Color(0xA9447744),

        )
    var buttonColorsChanger by mutableStateOf(
        listOf(
            mutableIntStateOf(1),
            mutableIntStateOf(1),
            mutableIntStateOf(1),
            mutableIntStateOf(1)
        ))
    var buttonsEnabler by mutableStateOf(true)

    private var countdownJob: Job? = null

    private var isItCorrect by mutableStateOf(false)
    var gameOver by mutableStateOf(false)

    val imageList = listOf(
        R.drawable.ic_geo,
        R.drawable.ic_hist,
        R.drawable.ic_art,
        R.drawable.ic_ent,
        R.drawable.ic_cien,
        R.drawable.ic_sport
    )

    var imageListSelector by mutableIntStateOf(0)

    private fun questionRandomizer() {
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


    private fun buttonDisabledColor(){
        for(i in buttonColorsChanger.indices)
            if(randomPositionsShuffled[i]== questionsList[random].correctOption){
                buttonColorsChanger[i].value = 2
            }else buttonColorsChanger[i].value = 1

    }

    fun changeDarkMode(onOrOff: Boolean) {
        darkOnOrOff = onOrOff

    }


    fun startCountdown() {
        countdownJob?.cancel()
        countdownJob = mainScope.launch {

            val minus = 1f / chosenTime
            if (!buttonsEnabler && roundsCounter <= chosenRounds) {
                delay(2000)
                roundsPlusOne()
                questionRandomizer()
                enableButtons()
            }
            for (i in remainingTime downTo 0) {
                imageSelector()
                changeTime(i)
                progress -= minus
                delay(1000)
                println(chosenTime)
                if (i == 0) {
                    stopCountdown()
                    startCountdown()
                }
            }
        }

    }


    fun stopCountdown() {
        countdownJob?.cancel()
        disableButtons()
        if (roundsCounter >= chosenRounds) {
            gameOver = true
        }

    }

    override fun onCleared() {

        super.onCleared()
        mainScope.cancel()

    }


    fun checkIfCorrect(option: String) {
        isItCorrect = if (option == questionsList[random].correctOption) {
            correct++
            true

        } else false
    }

    private fun roundsPlusOne() {
        changeTime(remainingTime)
        roundsCounter++
        progress=1.1f

    }

    private fun enableButtons() {
        buttonsEnabler = true
    }

    private fun disableButtons() {
        buttonsEnabler = false
        buttonDisabledColor()
    }

    fun reset() {
        gameOver = false
        correct = 0
        roundsCounter = 1
        progress = 1.1f
        remainingTime = chosenTime
    }


    private fun imageSelector() {
        imageListSelector = when (questionsList[random].category) {
            Category.Geografia -> 0
            Category.Historia -> 1
            Category.ArteYLiteratura -> 2
            Category.Entretenimiento -> 3
            Category.Ciencias -> 4
            Category.Deportes -> 5
        }
    }
}









