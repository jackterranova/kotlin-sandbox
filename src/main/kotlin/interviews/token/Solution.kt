package interviews.token


const val GET_COMMAND = 0
const val RESET_COMMAND = 1

fun numberOfTokens(expiryLimit: Int, commands: Array<Array<Int>>): Int {
    val tokens = mutableMapOf<Int, Int>()
    var lastKnownTime = 0

    commands.forEach {command ->
        when(command[0]) {
            GET_COMMAND -> createToken(tokens, command[1], command[2] + expiryLimit)
            RESET_COMMAND -> resetToken(expiryLimit, tokens, command[1], command[2])
            else -> Unit
        }

        lastKnownTime = command[2]
    }

    //given the last known time check how many active tokens
    var validTokens = 0
    //TODO convert to fold()
    tokens.values.forEach {expiry ->
        if(expiry >= lastKnownTime) validTokens++
    }

    return validTokens
}


fun createToken(tokens: MutableMap<Int, Int>, id: Int, expires: Int) {
    //ignore any attempt to create a token that already exists
    if(tokens.containsKey(id)) return

    tokens[id] = expires
}

fun resetToken(expiryLimit: Int, tokens: MutableMap<Int, Int>, id: Int, time: Int) {

    //ignore any attempt to reset a token that does not exist
    if(!tokens.containsKey(id)) return

    val tokenExpiry = tokens[id]!!
    if(tokenExpiry < time) return

    tokens[id] = time + expiryLimit
}

fun main(args: Array<String>) {
    numberOfTokens(3, arrayOf(arrayOf(0,1,1),arrayOf(1,1,5))).also {
        println(it)
    }
}