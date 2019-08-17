import java.util.*

class Solution71 {
    fun simplifyPath(path: String): String {

        val stack : Stack<String> = Stack()

        stack.push("/")

        for(i in 0 until path.length){
            val char = path[i]

            if(char == '/'){
                if(stack.peek() == "/"){
                    continue
                }
                if(stack.peek() == "."){
                    stack.pop()
                    continue
                }

                stack.push("$char")
                continue
            }

            if(char == '.'){
                if(stack.peek() == "."){
                    stack.pop()
                    if(stack.size > 1){
                        stack.pop()
                        stack.pop()
                    }
                    continue
                }

                stack.push("$char")
                continue
            }

            if(stack.peek() == "/"){
                stack.push("$char")
            } else{
                val top = stack.pop()
                stack.push("$top$char")
            }

        }

        var result = ""

        if(stack.peek() == "/" && stack.size > 1){
            stack.pop()
        }

        if(stack.peek() == "."){
            stack.pop()
        }

        while (!stack.empty()){
            result = "${stack.pop()}$result"
        }

        return result
    }
}

fun main(){
    val soultion = Solution71()

    val test1 = "/home/"
    val test2 = "/../"
    val test3 = "/home//foo/"
    val test4 = "/a/./b/../../c/"
    val test5 = "/a/../../b/../c//.//"
    val test6 = "/a//b////c/d//././/.."
    val test7 = "/."

    println(soultion.simplifyPath(test1))
    println(soultion.simplifyPath(test2))
    println(soultion.simplifyPath(test3))
    println(soultion.simplifyPath(test4))
    println(soultion.simplifyPath(test5))
    println(soultion.simplifyPath(test6))
    println(soultion.simplifyPath(test7))

}