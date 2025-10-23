package wordle

fun main() {
    try {
        val words = readWorldList("data/words.txt")
        println("loaded ${words.size} words")
        val targetWord = pickRandomWord(words)

        var gameOver = False
        var attempts = 0
        val maxAttempts = 10

        while(gameOver && attempts <= maxAttempts) {
            attempts++
            val guess = obtainGuess(attempts)
            val matches = evaluateGuess(guess, targetWord)
            displayGuess(guess, matches)

            if(guess == targetWord) {
                println("Congratulation! You guess the correct word at $attempts")
                gameOver = True
            }
            else if(attempts == maxAttempts) {
                println("You have no chance to attempt. The correct word is $targetWord")
                gameOver = True
            }
            else {
                catch (e: Exception) {
                    println("Error: ${e.message}")
                }
            }
        }
    }
}
