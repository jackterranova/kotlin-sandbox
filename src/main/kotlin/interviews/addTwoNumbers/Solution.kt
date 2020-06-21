package interviews.addTwoNumbers

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

/**
 *
 * We will iterate over lists and sum the individual values
 *
 * Overall the logic is simple with some necessary boundary checks (lists being different sizes).
 *
 * Iterate, add numbers and carry the one if necessary.
 *
 * One if the tricky bit in getting this writing a smooth algo is how to return a ptr to the head of the result list.
 *
 * Before iterating you need to create the fist result node so you can keep track of it and eventually send it back
 * to the client.
 *
 * One way to do this is to create an initial head node ("head") whose value will be zero and whose "next" field will point
 * to the real first value of the result.  This creates a sort of dead node whose only purpose is keep track of the head
 * of the list.  When returning to the caller you can simply return "head->next" and the dead node is ignored
 *
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        // init resultNode that we will send back to caller
        val resultNode = ListNode(0)
        var resultPtr = resultNode

        // create ptrs to the input lists
        var l1ptr = l1
        var l2ptr = l2

        var result = AdditionResult(0, false)

        // iterate and calculate
        while(l1ptr != null || l2ptr != null) {
            result = addNumbers(l1ptr?.`val`, l2ptr?.`val`, result.carryTheOne)

            // move the result ptr up to the current node
            resultPtr.next = ListNode(result.result)
            resultPtr = resultPtr.next!!

            // advance the ptrs in the input lists
            l1ptr = l1ptr?.next
            l2ptr = l2ptr?.next
        }

        if(result.carryTheOne) resultPtr.next = ListNode(1)

        return resultNode.next
    }

    private fun addNumbers(i: Int?, j: Int?, carryTheOne: Boolean = false): AdditionResult {
        return when {
            i == null -> AdditionResult(j!!, carryTheOne)
            j == null -> AdditionResult(i, carryTheOne)
            else -> AdditionResult(i + j, carryTheOne)
        }
    }
}

class AdditionResult(initialResult:Int, carryTheOnePrev: Boolean) {
    var result = if(carryTheOnePrev) initialResult + 1 else initialResult
    var carryTheOne = false

    init {
        if(result > 9) {
            result %= 10
            carryTheOne = true
        }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun main() {
    Solution().addTwoNumbers(toListNode(listOf<Int>(3,2,6)),toListNode(listOf<Int>(6,5,4))).also {
        var result = it

        while(result != null) {
            println(result.`val`)
            result = result.next
        }
    }
}

fun toListNode(list: List<Int>): ListNode =
    list.run {
        val firstNode = ListNode(first())
        var prevNode = firstNode

        subList(1, lastIndex+1).forEachIndexed { i, digit ->
            ListNode(digit).apply {
                prevNode.next = this
                prevNode = this
            }
        }

        firstNode
    }