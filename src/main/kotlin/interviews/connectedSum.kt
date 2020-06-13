package interviews

fun connectedSum(n: Int, edges: Array<String>): Int {
    val graph  = mutableMapOf<String, MutableList<String>>()
    for(i in 0 until n) {
        graph[(i+1).toString()] = mutableListOf<String>()
    }

    edges.forEach { e ->
        with(e.split(" ")) {
            graph[first()]?.add(last())
        }
    }

    var result = 0.0

    graph.forEach { node, neighbors ->

        when(neighbors.size) {
            0 -> {
                if(!graph.values.any {
                    it.contains(node)
                }) result++
            }
            else -> result += Math.ceil(Math.sqrt(neighbors.size.toDouble()))
        }
    }

    return result.toInt()
}

fun main() {
    connectedSum(4, arrayOf("1 2","1 4")).also { println(it) }
}