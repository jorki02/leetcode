import java.util.*

class Solution88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var index1 = m - 1
        var index2 = n - 1

        var indexPlace = n + m - 1

        while (indexPlace >= 0){
            if(index1 < 0){
                nums1[indexPlace--] = nums2[index2--]
                continue
            }

            if(index2 < 0){
                nums1[indexPlace--] = nums1[index1--]
                continue
            }

            if(nums1[index1] > nums2[index2]){
                nums1[indexPlace--] = nums1[index1--]
            } else {
                nums1[indexPlace--] = nums2[index2--]
            }
        }
    }
}

fun main(){
    val solution = Solution88()

    val nums1 = intArrayOf(1,2,3,0,0,0)
    val nums2 = intArrayOf(2,5,6)

    solution.merge(nums1, 3, nums2, 3)

    println(Arrays.toString(nums1))
}