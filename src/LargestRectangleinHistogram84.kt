import java.util.*

class Solution84 {
    fun largestRectangleArea(heights: IntArray): Int {
        val s: Stack<Int> = Stack()

        var maxArea = 0
        var tp: Int
        var areaWithTop: Int

        var i = 0
        while (i < heights.size) {
            if (s.empty() || heights[s.peek()] <= heights[i]) {
                s.push(i++)
            } else {
                tp = s.pop()

                areaWithTop = heights[tp] * if (s.empty()) i else i - s.peek() - 1

                if (maxArea < areaWithTop)
                    maxArea = areaWithTop
            }

        }

        while (!s.empty()) {
            tp = s.pop()

            areaWithTop = heights[tp] * if (s.empty()) i else i - s.peek() - 1

            if (maxArea < areaWithTop)
                maxArea = areaWithTop
        }

        return maxArea
    }
}

fun main(){
    val solution = Solution84()
    val arr = intArrayOf(999,999,999,999)
    //val arr = intArrayOf(2,1,5,6,2,3)
    //val arr = intArrayOf(2,8,4,3,4,11)


    val num = solution.largestRectangleArea(arr)

    println(num)
}