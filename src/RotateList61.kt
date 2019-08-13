class ListNode61(var `val`: Int) {
    var next: ListNode? = null
}

class Solution61 {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {

        var newHead = head
        var root = head

        while ()

        for(i in 0 until k){
            root = newHead
            newHead = head?.next
        }

        root?.next = null

        if(newHead != null){

        }

        return head
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

    val solution = Solution61()

    var newHead = solution.rotateRight(head, 3)

    while(newHead != null){
        println(newHead.`val`)
        newHead = newHead.next
    }
}