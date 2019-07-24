class Solution78 {

    val result: MutableList<List<Int>> = mutableListOf()

    fun subsets(nums: IntArray): List<List<Int>> {

        val arr: MutableList<Int> = mutableListOf()

        combineRecursive(0, nums.size, arr, nums)
        return result
    }

    private fun combineRecursive(start: Int, n: Int, arr: MutableList<Int>, nums: IntArray){
        if(start == n){
            result.add(arr.toMutableList())
            return
        }

        arr.add(nums[start])
        combineRecursive(start + 1, n, arr, nums)
        arr.removeAt(arr.size - 1)
        combineRecursive(start + 1, n, arr, nums)
    }
}

fun main(){
    val solution = Solution78()

    val nums = intArrayOf(1, 5)
    val result = solution.subsets(nums)

    for(value in result){
        println(value)
    }
}