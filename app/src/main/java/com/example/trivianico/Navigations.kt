package com.example.trivianico

sealed class Routes(val route: String){
    object Menu:Routes("menu")
    object Game:Routes("game")
    object Result:Routes("result")
    object Settings:Routes("settings")
}