package com.example.tictactoe

class Player(var PlayerSymbol:String, var turn:Boolean) {
    var selected: MutableList<Int> = mutableListOf()

    val condition1 = listOf<Int>(R.id.button6, R.id.button4, R.id.button5)
    val condition2 = listOf<Int>(R.id.button3, R.id.button2, R.id.button)
    val condition3 = listOf<Int>(R.id.button9, R.id.button8, R.id.button7)
    val condition4 = listOf<Int>(R.id.button6, R.id.button3, R.id.button9)
    val condition5 = listOf<Int>(R.id.button4, R.id.button2, R.id.button8)
    val condition6 = listOf<Int>(R.id.button5, R.id.button, R.id.button7)
    val condition7 = listOf<Int>(R.id.button6, R.id.button2, R.id.button7)
    val condition8 = listOf<Int>(R.id.button9, R.id.button2, R.id.button5)

    fun checkWinner(): Boolean {
        if (selected.containsAll(condition1) || selected.containsAll(condition2) ||
            selected.containsAll(condition3) || selected.containsAll(condition4) ||
            selected.containsAll(condition5) || selected.containsAll(condition6) ||
            selected.containsAll(condition7) || selected.containsAll(condition8)
        ) {
            return true
        } else {
            return false
        }

    }
}
