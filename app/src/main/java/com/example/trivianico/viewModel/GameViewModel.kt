package com.example.trivianico.viewModel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.ViewModel
import com.example.trivianico.R
import com.example.trivianico.model.Category
import com.example.trivianico.model.Diff
import com.example.trivianico.model.questionsList


class GameViewModel() : ViewModel() {
    val fonts = FontFamily(
        Font(R.font.josefinsans_regular)
    )

    var chosenDif by mutableStateOf("Easy")
    var chosenRounds by mutableIntStateOf(5)
    var chosenTime by mutableIntStateOf(7)
    var darkOnOrOff by mutableStateOf(false)
    var roundsCounter by mutableIntStateOf(1)
    var correct by mutableIntStateOf(0)
    var remainingTime by mutableIntStateOf(chosenTime)
        private set

    var random by mutableIntStateOf(questionsList.indices.random())

    private var randomPositions by mutableStateOf(
        listOf(
            questionsList[random].correctOption,
            questionsList[random].incorrectOption1,
            questionsList[random].incorrectOption2,
            questionsList[random].incorrectOption3
        )
    )
    var randomPositionsShuffled by mutableStateOf(randomPositions.shuffled())

    var appColors = listOf(
        Color(0xFFDAE6F2),
        Color(0xB2FF8181),
        Color(0xA9447744),
        Color(146, 193, 220, 255),
        Color(78, 100, 116, 255)
    )
    var buttonColorsChanger by mutableStateOf(
        listOf(
            mutableIntStateOf(1),
            mutableIntStateOf(1),
            mutableIntStateOf(1),
            mutableIntStateOf(1)
        )
    )
    var buttonsEnabler by mutableStateOf(true)

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
    var questionDiffListNumber by mutableStateOf(
        listOf(
            questionsList.filter { it.diff == Diff.Easy },
            questionsList.filter { it.diff == Diff.Normal },
            questionsList.filter { it.diff == Diff.Hard }

        )
    )
    var diffNumber by mutableIntStateOf(0)
    fun changeDif(dif: String) {
        chosenDif = dif
    }

    fun changeRounds(rounds: Int) {
        chosenRounds = rounds
    }

    fun changeTime(time: Int) {
        chosenTime = time

    }


    private fun buttonDisabledColor() {
        for (i in buttonColorsChanger.indices)
            if (randomPositionsShuffled[i] == questionDiffListNumber[diffNumber][random].correctOption) {
                buttonColorsChanger[i].value = 2
            } else buttonColorsChanger[i].value = 1

    }

    fun changeDarkMode(onOrOff: Boolean) {
        darkOnOrOff = onOrOff

    }


    fun stopCountdown() {
        disableButtons()
        if (roundsCounter >= chosenRounds) {
            gameOver = true
        }
    }

    fun checkIfCorrect(option: String) {
        isItCorrect = if (option == questionDiffListNumber[diffNumber][random].correctOption) {
            correct++
            true

        } else false
    }

    fun roundsPlusOne() {
        if (!buttonsEnabler && roundsCounter <= chosenRounds) {
            remainingTime = chosenTime
            roundsCounter++
//            questionRandomizer()
            questionsDiff()
            imageSelector()
            enableButtons()
        }

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
        remainingTime = chosenTime
//        questionRandomizer()
        questionsDiff()
        enableButtons()
    }


    fun imageSelector() {
        imageListSelector = when (questionDiffListNumber[diffNumber][random].category) {
            Category.Geografia -> 0
            Category.Historia -> 1
            Category.Arte -> 2
            Category.Entretenimiento -> 3
            Category.Ciencias -> 4
            Category.Deportes -> 5
        }
    }

    fun questionsDiff() {

        when (chosenDif) {
            "Easy" -> {
                diffNumber = 0
                questionDiffListNumber[0]
                random = questionDiffListNumber[0].indices.random()
                randomPositions = listOf(
                    questionDiffListNumber[diffNumber][random].correctOption,
                    questionDiffListNumber[diffNumber][random].incorrectOption1,
                    questionDiffListNumber[diffNumber][random].incorrectOption2,
                    questionDiffListNumber[diffNumber][random].incorrectOption3
                )
                randomPositionsShuffled = randomPositions.shuffled()
            }

            "Normal" -> {
                diffNumber = 1
                questionDiffListNumber[diffNumber]
                random = questionDiffListNumber[diffNumber].indices.random()
                randomPositions = listOf(
                    questionDiffListNumber[diffNumber][random].correctOption,
                    questionDiffListNumber[diffNumber][random].incorrectOption1,
                    questionDiffListNumber[diffNumber][random].incorrectOption2,
                    questionDiffListNumber[diffNumber][random].incorrectOption3
                )
                randomPositionsShuffled = randomPositions.shuffled()
            }

            else -> {
                diffNumber = 2
                questionDiffListNumber[diffNumber]
                random = questionDiffListNumber[diffNumber].indices.random()
                randomPositions = listOf(
                    questionDiffListNumber[diffNumber][random].correctOption,
                    questionDiffListNumber[diffNumber][random].incorrectOption1,
                    questionDiffListNumber[diffNumber][random].incorrectOption2,
                    questionDiffListNumber[diffNumber][random].incorrectOption3
                )
                randomPositionsShuffled = randomPositions.shuffled()
            }
        }
        println("Diff = $chosenDif")
        println()
        println(random)
        println(randomPositions)
    }
}









