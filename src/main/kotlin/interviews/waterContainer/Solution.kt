package interviews.waterContainer

import kotlin.math.min

class Solution {
    fun maxArea(height: IntArray): Int {
        var head  = 0
        var tail = height.lastIndex
        var biggestMaxArea = 0

        while(tail - head != 0) {
            val minHeight = Math.min(height[head],height[tail])
            val maxArea = minHeight * (tail - head)
            if(maxArea > biggestMaxArea) biggestMaxArea = maxArea

            if(height[head] > height[tail])
                tail-=1
            else
                head+=1
        }

        return biggestMaxArea
    }
}

fun main(args: Array<String>) {
    Solution().maxArea(intArrayOf(1,2,4,3)).also {
        println(it)
    }
}