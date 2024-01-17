package com.example.trivianico.viewModel


import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.ViewModel
import com.example.trivianico.R
import java.util.Timer
import java.util.TimerTask

class MyViewModel : ViewModel() {
    val fonts = FontFamily(
        Font(R.font.josefinsans_regular)
    )
    var time = Setting().chosenTime


    fun timer() {
        val timer = Timer()
        val delay = 1000L
        val period = 1000L
        var remainingTime = Setting().chosenTime

        val task = object : TimerTask() {
            override fun run() {
                if (remainingTime >= 0) {
                    println(remainingTime)
                    Setting().changeTime(remainingTime)
                    remainingTime--
                    time=remainingTime
                    println("Esta es la variable $time")
                } else {
                    timer.cancel()
                }
            }
        }
        timer.scheduleAtFixedRate(task, delay, period)
    }
}

