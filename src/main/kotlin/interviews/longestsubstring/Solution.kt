package interviews.longestsubstring

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.isEmpty()) return 0

        var longestLength = 1
        val charToIndexTable = HashMap<Char, Int>()

        charToIndexTable[s.first()] = 0
        var head = 0
        var tail = 0

        for(i in 1..s.lastIndex) {
            //widen the window to include current
            tail++

            //check if we have seen the current char in the current window
            val matchedIndex = charToIndexTable[s[i]]
            if(matchedIndex != null && matchedIndex >= head) {
                head = matchedIndex+1
            }

            // update the lookup table with current char's index
            charToIndexTable[s[tail]] = i

            // recalc longest based in new head/tail
            val currentLength = tail - head + 1
            if(currentLength > longestLength) longestLength = currentLength
        }

        return longestLength
    }
}

fun main(args: Array<String>) {
    println(Solution().lengthOfLongestSubstring("abba"))
}