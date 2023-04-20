package com.example.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var player1 = Player("X", true)
    var player2 = Player("0", false)
    var count = 0
    var list = listOf<Int>(R.id.button6,R.id.button4,R.id.button5,R.id.button3,R.id.button2,R.id.button,R.id.button9,R.id.button8,R.id.button7)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reset.setOnClickListener {
            player1 = Player("X", true)
            player2 = Player("0", false)
            player1.selected.clear()
            player2.selected.clear()

            list.forEach {
                findViewById<Button>(it).isEnabled = true
                findViewById<Button>(it).text = ""
            }
        }

    }
    fun controller(view: View){
        updateView(view)
    }

    fun updateView(view: View){
        var button = findViewById<Button>(view.id)
        if(!(player1.checkWinner() || player2.checkWinner())) {
            if (player1.turn) {
                button.text = player1.PlayerSymbol
                player1.selected.add(view.id)
                if (player1.checkWinner()) {
                    winner(player1)
                }
                toggleTurn()

            } else {
                button.text = player2.PlayerSymbol
                player2.selected.add(view.id)
                if (player2.checkWinner()) {
                    winner(player2)
                }else if(count == 8) {
                    Toast.makeText(this, "GAME DRAW", Toast.LENGTH_SHORT).show()


                }
                toggleTurn()
            }
            button.isEnabled = false
        }

    }

    fun toggleTurn(){
        if(player1.turn){
            player2.turn = true
            player1.turn = false
            count += 1
        } else{
            player2.turn = false
            player1.turn = true
            count += 1
        }
    }

    fun winner(p:Player){
        Toast.makeText(this,"PLAYER ${p.PlayerSymbol} Won", Toast.LENGTH_SHORT).show()
    }
}
