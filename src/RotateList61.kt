class ListNode61(var `val`: Int) {
    var next: ListNode? = null
}

class Solution61 {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if(head == null){
            return head
        }

        var lastNode = head
        var root = head

        var size = 1

        while (lastNode?.next != null){
            size++
            lastNode = lastNode.next
        }

        val rot = k%size

        if (rot == 0){
            return head
        }

        var newHead = head

        for(i in 0 until (size - rot)){
            root = newHead
            newHead = newHead?.next
        }

        lastNode?.next = head
        root?.next = null

        return newHead
    }
}

fun main(){
    var li = ListNode(1)
    val head = li
    var next = li

    next.next = ListNode(2)
    next = next.next!!
    next.next = ListNode(3)
    next = next.next!!
    next.next = ListNode(4)
    next = next.next!!
    next.next = ListNode(5)
/*    next = next.next!!
    next.next = ListNode(2)*/

    val solution = Solution61()

    var newHead = solution.rotateRight(head, 5)

    while(newHead != null){
        println(newHead.`val`)
        newHead = newHead.next
    }
}