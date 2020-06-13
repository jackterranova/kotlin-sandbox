import java.util.*
import kotlin.collections.HashMap

// [2,7,11,15] 9
//    7,11,15  9
// O(n) = Sum(n-1 where n:4 to 1)
// O(n) = nC2
class Solution {
    fun towSum1(nums: IntArray, target: Int): IntArray {
        var answers = mutableListOf<Pair<Int,Int>>()

        var bigO = 0

        nums.sliceArray(0..nums.lastIndex-1).forEachIndexed { index1, i1 ->
            nums.sliceArray(index1+1..nums.lastIndex).forEachIndexed {index2, i2 ->
                ++bigO
                if(i1 + i2 == target) answers.add(Pair(index1,index2 + index1 + 1))
            }
        }

        println(bigO)

        return answers.map { pair ->
            IntArray(2).apply {
                set(0, pair.first)
                set(1, pair.second)
            }
        }.first()
    }

    fun towSumBetter(nums: IntArray, target: Int): IntArray {
        val hash = Hashtable<Int, Int>()  // adding space complexity in lieu of time
        hash[target - nums.first()] =  0

        nums.sliceArray(1..nums.lastIndex).forEachIndexed { index, i ->
            hash[i]?.run {
                return intArrayOf(this,index+1)
            }
        }

        return intArrayOf()
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hash = HashMap<Int, Int>()  // adding space complexity in lieu of time
        hash[target - nums.first()] =  0

        for(i in 1..nums.lastIndex) {
            val complement = hash[nums[i]]
            if(complement == null) {
                hash[target - nums[i]] = i
            }
            else {
                return intArrayOf(complement,i)
            }
        }

        return intArrayOf()
    }
}

fun main(args: Array<String>) {
    Solution().twoSum(intArrayOf(3,2,4),6).forEach {
        println(it)
    }
}