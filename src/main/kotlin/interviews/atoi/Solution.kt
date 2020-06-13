package interviews.atoi

import java.lang.IllegalArgumentException

class Solution {
    fun myAtoi(str: String): Int {

        // loop over characters
        //   if number
        //     convert to int
        val number = mutableListOf<Int>()
        var isNegative = false

        val i = 0
        val iterator = str.iterator().withIndex()

        var firstNonWhiteChar: Char = ' '

        while (iterator.hasNext() && firstNonWhiteChar == ' ') {
            iterator.next().value.apply {
                firstNonWhiteChar = this
            }
        }

        if (firstNonWhiteChar == '-')
            isNegative = true
        else if (firstNonWhiteChar != '+' && !isANumber(firstNonWhiteChar))
            return 0
        else {
            if (isANumber(firstNonWhiteChar)) number.add(toInt(firstNonWhiteChar))
        }

        var current = ' '
        while (iterator.hasNext()) {
            current = iterator.next().value
            if (isANumber(current))
                number.add(toInt(current))
            else
                break
        }

        var result: Double = 0.0
        number.reversed().forEachIndexed { index, i ->
            result += (i.toDouble() * Math.pow(10.toDouble(), (index).toDouble()).toInt())
        }

        if (isNegative) {
            if (-result <= -2147483648.0)
                return -2147483648
            else
                return -result.toInt()
        } else {
            if (result > Int.MAX_VALUE.toDouble())
                return Int.MAX_VALUE
            else
                return result.toInt()
        }
    }

    private fun isANumber(c: Char): Boolean {
        return c in listOf<Char>('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
    }

    private fun toInt(numberAsChar: Char): Int {
        when (numberAsChar) {
            '0' -> return 0
            '1' -> return 1
            '2' -> return 2
            '3' -> return 3
            '4' -> return 4
            '5' -> return 5
            '6' -> return 6
            '7' -> return 7
            '8' -> return 8
            '9' -> return 9
        }

        throw IllegalArgumentException("Not a number")
    }
}


fun main(args: Array<String>) {
    Solution().myAtoi("-6147483648").run {
        println(this)
    }
}