class Solution76 {
    fun minWindow(s: String, t: String): String {
        val map = mutableMapOf<Char, Int>()
        val mapRegex = mutableMapOf<Char, Int>()
        val charsSize = t.length
        var foundChars = 0

        for(v in t){
            if(mapRegex.containsKey(v)){
                mapRegex[v] = mapRegex[v]!! + 1
            } else {
                mapRegex[v] = 1
            }
        }

        for(v in t){
            map[v] = 0
        }

        var right = 0
        var left = 0
        var size = 0
        var minSize = s.length + 1
        var minRight = s.length
        var minLeft = s.length

        while(right < s.length) {

            while (right < s.length) {
                if (foundChars == charsSize) {
                    break
                }

                if (map.containsKey(s[right])) {
                    if(map[s[right]]!! < mapRegex[s[right]]!!){
                        foundChars++
                    }

                    map[s[right]] = map[s[right]]!! + 1
                }

                right++
                size++
            }

            if(foundChars == charsSize){
                while (left < right) {
                    if (map.containsKey(s[left])) {
                        map[s[left]] = map[s[left]]!! - 1
                        if(map[s[left]]!! < mapRegex[s[left]]!!){
                            if(size < minSize){
                                minLeft = left
                                minRight = right
                                minSize = size
                            }
                            foundChars--
                            left++
                            size--
                            break
                        }
                    }

                    left++
                    size--
                }
            }
        }

        return s.substring(minLeft,minRight)
    }
}

fun main(){
    val solution = Solution76()

    println(solution.minWindow("cwaefgc", "cae"))
}