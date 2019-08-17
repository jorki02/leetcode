class Solution79 {

    fun exist(board: Array<CharArray>, word: String): Boolean {

        if(board.isEmpty()) {
            return false
        }

        val visited = Array(board.size) { Array(board[0].size) {false}}

        for(i in 0 until board.size){
            for(j in 0 until board[0].size){
                if(check(board, word, visited, i, j)){
                    return true
                }
            }
        }

        return false
    }

    private fun check(board: Array<CharArray>, word: String, visited: Array<Array<Boolean>>, i: Int, j: Int): Boolean{

        if(word.isEmpty()){
            return true
        }

        if(i < 0 || i >= board.size || j < 0 || j >= board[0].size || visited[i][j] || board[i][j] != word[0]){
            return false
        }

        visited[i][j] = true

        if(check(board, word.substring(1), visited, i + 1, j) ||
                check(board, word.substring(1), visited, i, j + 1) ||
                check(board, word.substring(1), visited, i, j - 1) ||
                check(board, word.substring(1), visited, i - 1, j)){
            return true
        }

        visited[i][j] = false

        return false
    }


}

fun main(){
    val solution = Solution79()

    val board = arrayOf(
            charArrayOf('A','B','C','E'),
            charArrayOf('S','F','C','S'),
            charArrayOf('A','D','E','E')
    )

    println(solution.exist(board, "ABCCED"))
    println(solution.exist(board, "SEE"))
    println(solution.exist(board, "ABCB"))
}