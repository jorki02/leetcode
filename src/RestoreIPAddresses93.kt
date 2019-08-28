import java.lang.Integer.min

class Solution93{
    var result: MutableList<String> = mutableListOf()

    fun restoreIpAddresses(s: String): List<String> {
        result = mutableListOf()

        if(s.length > 12){
            return result
        }

        val address: MutableList<Int> = mutableListOf()

        recursive(0, address, 0, s)

        return result
    }

    private fun recursive(level: Int, address:MutableList<Int>, start: Int, s: String){
        if(level == 4 && start == s.length){
            result.add(address.joinToString("."))
        }

        if(start >= s.length){
            return
        }

        val clause = min(2, s.length - start - 1)

        for (i in start..start + clause) {
            val number = s.substring(start, i + 1).toInt()
            if (!checkInvalid(s.substring(start, i + 1), level)) {
                address.add(number)
                recursive(level + 1, address, i + 1, s)
                address.removeAt(address.size - 1)
            }
        }
    }

    private fun checkInvalid(s: String, level: Int): Boolean{
        val number = s.toInt()
        return number > 255 || (s[0] == '0' && s.length > 1)
    }
}

fun main(){
    val solution = Solution93()
    val input1 = "25525511135"
    val input2 = "255"
    val input3 = "2552"
    val input4 = "25555511135"
    val input5 = "255255115"
    val input6 = "25525515"
    val input7 = ""
    val input8 = "010010"

    println(solution.restoreIpAddresses(input1))
    println(solution.restoreIpAddresses(input2))
    println(solution.restoreIpAddresses(input3))
    println(solution.restoreIpAddresses(input4))
    println(solution.restoreIpAddresses(input5))
    println(solution.restoreIpAddresses(input6))
    println(solution.restoreIpAddresses(input7))
    println(solution.restoreIpAddresses(input8))
}