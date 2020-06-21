package interviews.reverseInteger

/**
 *
 * https://leetcode.com/problems/reverse-integer/
 *
 * The idea behind this algo, is to grab digits from the right of the number by dividing by 10
 * and place them on the left of the return value by multiplying by 10.
 *
 * This is one of the purest forms of algorithms and in that it is a little difficult (for me anyway) to
 * initially grasp how to know the magnitude of the latest digit popped from the input.  The key is to realize that
 * you simply multiply the entire running total by 10 for each time through the loop and then add the number you just
 * popped.  Each digit pushed to the return value is assumed to be in the ones place until we push the next digit.
 * AND, the initial pass multiples 10 by the initial value zero, covering that corner case.
 *
 * The last corner case is a negative number.  You might be tempted to start coding a loop like `while(initial > 0)`
 * since you may forget that the number can be negative.   The simple solution to that is to realize that whether neg
 * or pos, your loop is finished when you reach zero => hence the loop can simply look like `while(initial != 0)
 *
 * while(initial:123 > 0)
 *   0:  retval = (retval * 0) + 3   [3]
 *   0:  retval = (retval * 1) + 2   [32]
 *   0:  retval = (retval * 2) + 1   [321]
 *
 */

const val ALMOST_MAX = Int.MAX_VALUE / 10
const val ALMOST_MIN = Int.MIN_VALUE / 10

class Solution {

    fun reverse(x: Int): Int {
        var initial = x
        var retval = 0

        while(initial != 0) {
            val digit = initial % 10
            initial /= 10

            // Checking for overflow
            // MAX =>  2147483647
            // MIN => -2147483648

            // if our retval would overflow by multiplying by 10
            // OR
            // if our retval would overflow if it is exactly 214748364/-214748364 and digit is 7,8,9 for pos and 0,-1,-2,-3,-4,-5,-6,-7
            if (retval > ALMOST_MAX || (retval == ALMOST_MAX) && digit > 7) return 0
            if (retval < ALMOST_MIN || (retval == ALMOST_MIN) && digit < -8) return 0

            retval = (retval * 10) + digit
        }

        return retval
    }
}

fun main() {
    Solution().reverse(-123).also {
        println(it)
    }
}