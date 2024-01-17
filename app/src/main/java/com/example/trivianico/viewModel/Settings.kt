package com.example.trivianico.viewModel

import androidx.lifecycle.ViewModel


class Setting: ViewModel() {

    var chosenDif = "Easy"
    var chosenRounds = 5
    var chosenTime = 7
    var darkOnOrOff = false

    fun changeDif(dif:String){
        chosenDif = dif
    }
    fun changeRounds(rounds:Int){
        chosenRounds = rounds
    }
    fun changeTime(time:Int){
        chosenTime = time

    }
    fun changeDarkMode(onOrOff:Boolean){
        darkOnOrOff = onOrOff
    }
}