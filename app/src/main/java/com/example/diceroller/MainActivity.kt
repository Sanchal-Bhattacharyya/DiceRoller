package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById<Button>(R.id.button);
        var countMatch:Int = 0;
        var countMismatch:Int = 0;

        rollButton.setOnClickListener {
            val firstResult:Int = rollFirstDice();
            val secondResult:Int = rollSecondDice();
            if(firstResult == secondResult) {
                countMatch++;
            }
            else{
                countMismatch++;
            }
            similarityPercent(countMatch, countMismatch);
            Toast.makeText(this, "Dice has been rolled ${countMatch+countMismatch} times!", Toast.LENGTH_SHORT).show();
        }
    }

    private fun similarityPercent(countMatch:Int, countMismatch:Int) {
        val matchPercent:Double = countMatch.toDouble()/(countMatch.toDouble()+countMismatch.toDouble())*(100.toDouble());
        val resultTextView:TextView = findViewById<TextView>(R.id.textView6);
        resultTextView.text = String.format("%.3f", matchPercent);
    }

    //Second Dice has eight sides
    private fun rollSecondDice():Int {
        val secondDice = Dice();
        val secondDiceRoll:Int = secondDice.roll();
        val secondDiceImage:ImageView = findViewById<ImageView>(R.id.imageView2);
        assignDiceImage(secondDiceRoll, secondDiceImage);
        return secondDiceRoll;
    }

    //First Dice has six sides
    private fun rollFirstDice():Int {
        val firstDice = Dice();
        val firstDiceRoll:Int = firstDice.roll();
        val firstDiceImage:ImageView = findViewById<ImageView>(R.id.imageView);
        assignDiceImage(firstDiceRoll, firstDiceImage);
        return firstDiceRoll;
    }

    private fun assignDiceImage(diceRoll:Int, diceImage:ImageView) {
        when(diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1);
            2 -> diceImage.setImageResource(R.drawable.dice_2);
            3 -> diceImage.setImageResource(R.drawable.dice_3);
            4 -> diceImage.setImageResource(R.drawable.dice_4);
            5 -> diceImage.setImageResource(R.drawable.dice_5);
            6 -> diceImage.setImageResource(R.drawable.dice_6);
        }
    }
}
