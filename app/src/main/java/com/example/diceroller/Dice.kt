package com.example.diceroller

class Dice(private val numSides:Int = 6) {

    fun roll():Int {

        val diceRange:IntRange = 1..numSides;
        val randomNumber:Int = diceRange.random();
        return randomNumber;
    }
}