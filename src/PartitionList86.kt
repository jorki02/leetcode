
class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        var headGe: ListNode? = null
        var headLr: ListNode? = null

        var tailGt: ListNode? = null
        var tailLr: ListNode? = null

        var nextNode: ListNode? = head
        var currentNode: ListNode? = head

        while (currentNode != null){
            nextNode = currentNode.next

            currentNode.next = null

            if(currentNode.`val` >= x){
                if(headGe == null){
                    headGe = currentNode
                }

                if(tailGt != null){
                    tailGt.next = currentNode
                }

                tailGt = currentNode
            } else {
                if(headLr == null){
                    headLr = currentNode
                }

                if(tailLr != null){
                    tailLr.next = currentNode
                }

                tailLr = currentNode
            }

            currentNode = nextNode
        }

        val returnHead: ListNode?

        if(tailLr != null){
            tailLr.next = headGe
            returnHead = headLr
        } else {
            returnHead = headGe
        }

        return returnHead
    }
}

fun main(){
    var li = ListNode(1)
    val head = li
    var next = li

    next.next = ListNode(4)
    next = next.next!!
    next.next = ListNode(3)
    next = next.next!!
    next.next = ListNode(2)
    next = next.next!!
    next.next = ListNode(5)
    next = next.next!!
    next.next = ListNode(2)

    val solution = Solution()

    var sorted = solution.partition(head, 3)

    while(sorted != null){
        println(sorted.`val`)
        sorted = sorted.next
    }
}