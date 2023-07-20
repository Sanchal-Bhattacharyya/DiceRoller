package com.example.diceroller

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

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
        val secondDice = Dice(8);
        val secondDiceRoll = secondDice.roll();
        val resultTextView:TextView = findViewById<TextView>(R.id.textView2);
        resultTextView.text = secondDiceRoll.toString();
        return secondDiceRoll;
    }

    //First Dice has six sides
    private fun rollFirstDice():Int {
        val firstDice = Dice();
        val firstDiceRoll = firstDice.roll();
        val resultTextView:TextView = findViewById<TextView>(R.id.textView);
        resultTextView.text = firstDiceRoll.toString();
        return firstDiceRoll;
    }
}
