class Solution70 {
    fun climbStairs(n: Int): Int {
        var prev1 = 1
        var prev2 = 1

        for(i in 2..n){
            val next = prev1 + prev2
            prev1 = prev2
            prev2 = next
        }

        return prev2
    }
}

fun main(){
    val solution = Solution70()

    val result = solution.climbStairs(2)

    println(result)
}