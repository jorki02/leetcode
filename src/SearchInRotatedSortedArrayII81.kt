class Solution81{
    fun search(nums: IntArray, target: Int): Boolean {
        if(nums.size == 0){
            return false
        }

        val place = binarySearchDrop(nums, 0, nums.size - 1)

        println(place)

        var leftIndex = 0

        if(place > 0){
            leftIndex = binarySearch(nums, 0, place - 1, target)
        }

        val rightIndex = binarySearch(nums, place, nums.size - 1, target)

        return nums[leftIndex] == target || nums[rightIndex] == target
    }

    private fun binarySearch(nums: IntArray, start: Int, end: Int, target: Int): Int{
        if(start == end){
            return start
        }

        val middle = (end + start) / 2

        return if (nums[middle] >= target) {
            binarySearch(nums, start, middle, target)
        } else {
            binarySearch(nums, middle + 1, end, target)
        }

    }

    private fun binarySearchDrop(nums: IntArray, start: Int, end: Int): Int {

        var newStart = start

        while(newStart < nums.size - 1 && nums[newStart] == nums[end]){
            newStart++
        }

        if (end - newStart <= 1) {
            if(nums[end] >= nums[newStart]){
                return newStart
            }
            return end
        }

        val middle = (end + newStart) / 2

        return if (nums[middle] > nums[end]) {
            binarySearchDrop(nums, middle, end)
        } else {
            binarySearchDrop(nums, newStart, middle)
        }
    }
}

fun main(){
    val solution = Solution81()

    val nums1 = intArrayOf(0)
    val nums2 = intArrayOf(6,0,0,1,2,2,5)
    val nums3 = intArrayOf(5,6,0,0,1,2,2)
    val nums4 = intArrayOf(2,5,6,0,0,1,2)
    val nums5 = intArrayOf(2,2,5,6,0,0,1)
    val nums6 = intArrayOf(1,2,2,5,6,0,0)
    val nums7 = intArrayOf(0,1,2,2,5,6,0)
    val nums8 = intArrayOf(2,2,2,0,2,2)

    val target = 0

    println(solution.search(nums1, target))
    println(solution.search(nums2, target))
    println(solution.search(nums3, target))
    println(solution.search(nums4, target))
    println(solution.search(nums5, target))
    println(solution.search(nums6, target))
    println(solution.search(nums7, target))
    println(solution.search(nums8, target))
}