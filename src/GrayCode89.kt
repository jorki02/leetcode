class Solution89 {

    val list = mutableSetOf<Int>()

    fun grayCode(n: Int): List<Int> {
        val used = Array(n) {false}

        list.add(0)
        recursive(0, used, n)

        return list.toList()
    }

    private fun recursive(prevNum: Int, used: Array<Boolean>, n: Int){
        for(jump in 0 until n){
            if(used[jump]){
                continue
            }
            val newNum = prevNum.or(1.shl(jump))
            list.add(newNum)

            used[jump] = true
            recursive(newNum, used, n)
            used[jump] = false
        }
    }
}

fun main(){
    val solution89 = Solution89()

    val list = solution89.grayCode(2)

    println(list)
}