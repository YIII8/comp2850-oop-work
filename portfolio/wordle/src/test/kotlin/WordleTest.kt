package wordle

import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({
    // Write your tests here
    "Texting function of isVaild" {
        isValid("ABACK") shouldBe True
        isValid("ABOUT") shouldBe True
        isValid("ABOU") shouldBe False
        isValid("ABOUTT") shouldBe False
        isValid("12345") shouldBe False
        isValid("ABOU?") shouldBe False
    }

    "Texting function of readWorldList" {
        val testFile = File("textwords.txt")
        testFile.writeText("ABOUT\nABACK\nABASE\nABBEY\n")
        val words = readWorldList("textwords.txt")
        words.size shouldBe 2
        words shouldBe mutableListOf("ABOUT", "ABACK")
        testFile.delete()
    }

    "Texting function of pickRandomWord" {
        val wordList = mutableListOf("ABOUT", "ABACK", "ABASE", "ABBEY")
        val originalSize = wordList.size
        val randomWord = pickRandomWord(wordList)
        wordList.size shouldBe originalSize - 1
        wordList.contains(randomWord) shouldBe False
        randomWord.length shouldBe 5
    }

    "Texting function of evaluateGuess" {
        evaluateGuess("ABOUT", "ABOUT") shouldBe listOf(1,1,1,1,1)
        evaluateGuess("ATUOB", "ABOUT") shouldBe listOf(1,0,0,0,0)
        evaluateGuess("QQQQQ", "ABOUT") shouldBe listOf(0,0,0,0,0)
    }
})
