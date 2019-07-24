import java.util.*

class Solution75 {
    fun sortColors(nums: IntArray): Unit {
        if(nums.isEmpty()) return

        val size = nums.size

        var start = 0
        var end = size - 1

        while(start < size && nums[start] == 0) start++
        while(end >= 0 && nums[end] == 2) end--

        for(i in 0 until nums.size){
            if(i < start){
                continue
            }

            if(start > end){
                break
            }

            if(i > end){
                break
            }

            if(nums[i] == 1){
                continue
            }

            if(nums[i] == 0){
                val temp = nums[start]
                nums[start] = nums[i]
                nums[i] = temp
                start++
                while(start < size && nums[start] == 0) start++

                if(nums[i] == 2){
                    val temp = nums[end]
                    nums[end] = nums[i]
                    nums[i] = temp
                    end--
                    while(end >= 0 && nums[end] == 2) end--
                }
            }

            if(nums[i] == 2){
                val temp = nums[end]
                nums[end] = nums[i]
                nums[i] = temp
                end--
                while(end >= 0 && nums[end] == 2) end--

                if(nums[i] == 0) {
                    val temp = nums[start]
                    nums[start] = nums[i]
                    nums[i] = temp
                    start++
                    while(start < size && nums[start] == 0) start++
                }
            }
        }
    }

}

fun main(){
    val solution = Solution75()

    val array = intArrayOf(0)

    solution.sortColors(array)

    println(Arrays.toString(array))
}