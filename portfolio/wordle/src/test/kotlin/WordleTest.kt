package wordle

import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({
    // Write your tests here
    "Texting function of isVaild" {
        isValid("ABACK") shouldBe true
        isValid("ABOUT") shouldBe true
        isValid("ABOU") shouldBe false
        isValid("ABOUTT") shouldBe false
        isValid("12345") shouldBe false
        isValid("about") shouldBe false
    }

    "Texting function of readWordList" {
        val testFile = File("textwords.txt")
        testFile.writeText("ABOUT\nABACK\nABASE\nABBEY\n")
        val words = readWordList("textwords.txt")
        words.size shouldBe 4
        words shouldBe mutableListOf("ABOUT", "ABACK", "ABASE", "ABBEY")
        testFile.delete()
    }

    "Texting function of pickRandomWord" {
        val wordList = mutableListOf("ABOUT", "ABACK", "ABASE", "ABBEY")
        val originalSize = wordList.size
        val randomWord = pickRandomWord(wordList)
        wordList.size shouldBe originalSize - 1
        wordList.contains(randomWord) shouldBe false
        randomWord.length shouldBe 5
    }

    "Texting function of evaluateGuess" {
        evaluateGuess("ABOUT", "ABOUT") shouldBe listOf(1,1,1,1,1)
        evaluateGuess("ATUOB", "ABOUT") shouldBe listOf(1,0,0,0,0)
        evaluateGuess("QQQQQ", "ABOUT") shouldBe listOf(0,0,0,0,0)
    }
})