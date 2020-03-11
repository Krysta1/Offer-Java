/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * 解题思路：dfs+回溯
 * 当递归到word最后一个位置的时候，返回最后一个字符和当前board位置的比较情况。
 * 如果board和word(index)相等的话，对上下左右四个方向去dfs搜索，搜索是注意是否被访问过，位置有没有越界。
 * 否则返回false
 *
 * 注意：要从盘面每个位置开始dfs搜索，而不是简单的从0,0开始。第一次提交犯了这个错误。
 *      还有只会在为true的时候才能返回true，其他情况下要继续进行搜索。
 */
class Solution {
    boolean[][] seen; // 标记访问过位置。
    int m, n;  // 行列数
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    boolean flag;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) return false;
        n = board[0].length;
        seen = new boolean[m][n];
        if ( m * n < word.length()) return false;
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                if (dfs(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int index, int x, int y){
        if (index == word.length() - 1){
            return word.charAt(index) == board[x][y];
        }
        if (word.charAt(index) == board[x][y]){
            seen[x][y] = true;
            for ( int k = 0; k < 4; k ++){
                int xx = x + dx[k];
                int yy = y + dy[k];
                if (inArea(xx, yy) && !seen[xx][yy] && dfs(board, word, index+1, xx, yy)){
                    return true;
                }
            }
            seen[x][y] = false;
        }
        return false;
    }

    public boolean inArea(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
