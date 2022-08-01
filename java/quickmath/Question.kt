package com.subhash1e.quickmath

import java.util.*
import java.util.Collections.swap

// this class creates question

data class Question(
        private var upperLimit:Int = 0,
        private var firstNumber:Int = 0,
        private var secondNumber:Int = 0,
        private var answer:Int = 0,
        private var answerArray:MutableList<Int> = mutableListOf<Int>(),
        private var answerPosition:Int = 0,
        private var questionPhrase:String = ""
) {

constructor(upperLimit:Int) : this(){
    this.upperLimit = upperLimit
    val randomNumber = Random()
    this.firstNumber = randomNumber.nextInt(upperLimit)
    this.secondNumber = randomNumber.nextInt(upperLimit)
    this.answer = this.firstNumber + this.secondNumber
    this.answerPosition = randomNumber.nextInt(4)
    this.answerArray[0] = answer + 1
    this.answerArray[1] = answer + 11
    this.answerArray[2] = answer - 5
    this.answerArray[3] = answer - 2

    this.answerArray  = shuffleArray(this.answerArray)



}

    private fun shuffleArray(answerArray: MutableList<Int>): MutableList<Int> {
            var index:Int;
        val randomNumber = Random()
        for (i in 3 downTo 0){
            index = randomNumber.nextInt(i+1)
            swap(answerArray,i,index)
        }
        return answerArray
    }




}