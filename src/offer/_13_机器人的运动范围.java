/**
 *地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 解题思路：
 * 1. dfs 对盘面所有位置进行dfs搜索，如果满足条件：
 *      1 在盘面范围内
 *      2 还没有被访问过
 *      3 自定义的加和运算小于k   这个时候在该位置的四个方向进行递归，并求和。
 * 2. bfs 用(0,0)开始，加入队列，
 *        将队首元素弹出队列，将visited置为true，并将右方和下方满足条件的位置加入的队列中，
 *        res++
 * 这里有个问题，如何实现一个Queue里面是Pair键值对？
 *
 */
class Solution { // dfs
    boolean[][] visited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int row, coj;
    public int movingCount(int m, int n, int k) {
        if (m == 0) return 0;
        row = m;
        coj = n;
        visited = new boolean[row][coj];
        int res = dfs(0, 0, k);
        return res;
    }
    public int dfs(int x, int y, int k){
        if (inArea(x, y) && !visited[x][y] && sum(x) + sum(y) <= k){
            int ans = 0;
            visited[x][y] = true;
            for( int i = 0; i < 4; i ++){
                int xx = x + dx[i];
                int yy = y + dy[i];
                ans += dfs(xx, yy, k);
            }
            return ans + 1;
        }
        return 0;
    }
    public boolean inArea(int x, int y){
        return x >= 0 && x < row && y >= 0 && y < coj;
    }

    public int sum(int x){
        int res = 0;
        while(x > 0){
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}

class Solution {
    boolean[][] visited;
    int row, coj;

    public int movingCount(int m, int n, int k) {
        if (m == 0) return 0;
        row = m;
        coj = n;
        int res = 0;
        visited = new boolean[row][coj];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (queue.size() > 0) {
            int[] tmp = queue.poll();
            int x = tmp[0], y = tmp[1];
            if (!inArea(x, y) || visited[x][y] || sum(x) + sum(y) > k) continue;
            visited[x][y] = true;
            res++;
            queue.add(new int[]{x + 1, y});
            queue.add(new int[]{x, y + 1});
        }

        // int res = dfs(0, 0, k);
        return res;
    }
}