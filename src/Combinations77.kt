import java.util.*
import java.util.Collections.copy

class Solution77 {

    val result: MutableList<List<Int>> = mutableListOf()

    fun combine(n: Int, k: Int): List<List<Int>> {

        val arr: MutableList<Int> = mutableListOf()

        combineRecursive(1, n, k, arr)
        return result
    }

    private fun combineRecursive(start: Int, n: Int, k: Int, arr: MutableList<Int>){
        if(k == 0){
            result.add(arr.toMutableList())
        }

        for(i in start..n){
            arr.add(i)

            combineRecursive(i + 1, n, k - 1, arr)

            arr.removeAt(arr.size - 1)
        }
    }
}

fun main(){
    val solution = Solution77()

    val result = solution.combine(4, 2)

    for(value in result){
        println(value)
    }
}