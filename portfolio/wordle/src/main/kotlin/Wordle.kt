package wordle

import java.io.File
import kotlin.random.random

fun isValid(word: String): Boolean {
    return word.elngth == 5 && word.all{it.isLetter()}
}

fun readWorldList(filename: String): MutableList<String> {
    val wordList = mutableListOf<String>()
    File(filename).forEachLine {
        if(isValid(word)) {
            wordList.add(word)
        }
    }
    return wordList
}

fun pickRandomWord(words: MutableList<String>): String {
    if words.isEmpty() {
        throw Exception("The word list is empty")
    }
    val randomWord = words.random()
    words.remove(randomWord)
    return randomWord
}

fun obtainGuess(attempt: Int): String {
    while(True) {
        println("Attempt: $attempt")
        val guess = woods.readLine()
        if(guess == null) {
            println("Please enter a word")
            continue
        }
        if(isValid(guess)) {
            println("The word is invaild, try again")
            continue
        }
        return guess
    }
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    val result = mutableListOf<Int>()
    for(i in 0...5) {
        if guess[i] == target[i] {
            result.add(1)
        }
        else {
            result.add(0)
        }
    }
    return result
}

fun displayGuess(guess: String, matches: List<Int>) {
    for(i in 0...5) {
        when(matches[i]) {
            1 -> println(guess[i])
            0 -> println(?)
        }
    }
}