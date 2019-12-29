fun main (){

    val solution = Solution97()

    val res = solution.isInterleave("aabcc", "dbbca", "aadbbbaccc")

    println(res)
}

class Solution97 {

    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val dp= Array(s1.length + 1) { Array(s2.length + 1) { false } }
        dp[0][0] = true


        if (s3.length != s1.length + s2.length) {
            return false
        }

        for(i in 0..s1.length){
            for(j in 0..s2.length) {
                if(i == 0 && j == 0){
                    continue
                } else if(i == 0){
                    dp[i][j] = dp[i][j - 1] && s2[j - 1] == s3[j + i - 1]
                } else if(j == 0){
                    dp[i][j] = dp[i - 1][j] && s1[i - 1] == s3[j + i - 1]
                } else{
                    dp[i][j] = (dp[i - 1][j] && s1[i - 1] == s3[j + i - 1]) || (dp[i][j - 1] && s2[j - 1] == s3[j + i - 1] )
                }
            }
        }

        return dp[s1.length][s2.length]
    }
}