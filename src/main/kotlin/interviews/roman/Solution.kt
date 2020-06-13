package interviews.roman

class Solution {
    /***
     *
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
     */

    fun romanToInt(s: String): Int {
        return parse(s)
    }

    fun parse(s: String): Int {
        var count = 0

        for(i in 0..s.lastIndex) {
            val it = s[i]
            if(it in arrayOf('I','X','C') && i < s.lastIndex && s.substring(i..i+1) in arrayOf("IV","IX","XL","XC","CD","CM")) {
                when(it) {
                    'I' -> count -= 1
                    'X' -> count -= 10
                    'C' -> count -= 100
                    else -> count = count
                }
            } else {
                when(it) {
                    'I' -> count += 1
                    'V' -> count += 5
                    'X' -> count += 10
                    'L' -> count += 50
                    'C' -> count += 100
                    'D' -> count += 500
                    'M' -> count += 1000
                }
            }
        }

        return count
    }
}

fun main(args: Array<String>) {
    val s = Solution()
    listOf<String>("III","IV","IX","LVIII","MCMXCIV","DCXXI").forEach {
        s.romanToInt(it).also {
            println(it)
        }
    }

}