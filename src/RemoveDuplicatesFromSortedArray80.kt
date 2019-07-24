import java.util.*

class Solution80 {
    fun removeDuplicates(nums: IntArray): Int {
        if(nums.size < 3){
            return nums.size
        }

        var size = nums.size
        var min = nums[0] - 1

        var prevNum = nums[0]
        var seenNum = 1

        for(i in 1 until nums.size){
            if(nums[i] == prevNum){
                if(seenNum >= 2){
                    nums[i] = min
                    size--
                } else {
                    seenNum++
                }
            } else {
                prevNum = nums[i]
                seenNum = 1
            }
        }

        var lastFree = 0
        var lastBusy = 0

        while (lastFree < nums.size && nums[lastFree] != min) {
            lastFree++
        }

        lastBusy = lastFree

        while (true) {
            while (lastBusy < nums.size && nums[lastFree] != min) {
                lastFree++
            }

            while (lastBusy < nums.size && nums[lastBusy] == min) {
                lastBusy++
            }

            if(lastBusy == nums.size){
                break
            }

            val tempFree = nums[lastFree]
            val tempBusy = nums[lastBusy]
            nums[lastFree] = tempBusy
            nums[lastBusy] = tempFree
        }

        return size
    }
}

fun main(){
    val solution = Solution80()

    val nums = intArrayOf(1,2,2)
    val result = solution.removeDuplicates(nums)

    println(result)

    println(Arrays.toString(nums))
}