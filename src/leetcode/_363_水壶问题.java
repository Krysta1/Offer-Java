/**
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 你允许：装满任意一个水壶，清空任意一个水壶，从一个水壶向另外一个水壶倒水，直到装满或者倒空
 *
 * 解题思路：
 * 1.BPS解法：
 *      考虑两个水壶的状态，假设现在两个水壶的状态为(x, y)，首先根据允许的操作可以发现，不会出现两个水壶都是半满的状态。
 *      如果其中一个是半满，那么另一个一定是空的或者是满的。这时也不能半满的水壶中的水倒掉或者倒满，这样会回到其他状态。
 *      所以两个水壶只有六个有效的转移状态。这里使用Pair，之前一直没用明白，哈哈。
 *      将x填满
 *      将y填满
 *      将x倒空
 *      将y倒空
 *      将x中的水倒入y中，直到y满或者x空，此时倒出了水量为min(currX, y - currY)
 *      将y中的水倒入x中，直到x满或者y空，此时倒出了水量为min(x - currX, currY)
 *      一次向一个队列中添加六种转移状态，并使用一个set来保存已经记录过的状态。
 *      如果在操作的过程中发现x,y或者是x+y=z的话，那么就证明可以返回true。
 *      直到遍历完所有的状态都没有成功则返回false
 * 2.数学方法：裴蜀定理（说明了对任何整数a、b和它们的最大公约数d，关于未知数x和y的线性不定方程（称为裴蜀等式）：
 *      若a,b是整数,且gcd(a,b)=d，那么对于任意的整数x,y,ax+by都一定是d的倍数，特别地，一定存在整数x,y，使ax+by=d成立。）
 *      通过上面分析，可以得知把一个半满的水壶中的水放空或者填满都是没有意义的。
 *      那么也就是说我们每次操作过后的水的变化量+-x和+-y
 *      经过若干次操作总计的变化量就是ax + by 其中a，b为整数
 *      我们的目标是使得ax + by = z也就是说这里x和y的最大公约数是z的一个约数即可。
 *      使用辗转相除法求解最大公约数。
 */
// import java.util.*;
// import javafx.util.Pair;
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) return true;
        // if (x == 0 && y == 0) return false;
        if (z > x + y) return false;
        // return (z % gcd(x, y) == 0);
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        Pair<Integer, Integer> start = new Pair<>(0, 0);
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while ( !queue.isEmpty() ){
            Pair<Integer, Integer> entry = queue.poll();
            int currX = entry.getKey();
            int currY = entry.getValue();

            if ( currX == z || currY == z || currX + currY == z) return true;

            helper(queue, visited, new Pair<>(x, currY));
            helper(queue, visited, new Pair<>(currX, y));

            helper(queue, visited, new Pair<>(currX, 0));
            helper(queue, visited, new Pair<>(0, currY));

            int moveSize = Math.min(currX, y - currY);
            helper(queue, visited, new Pair<>(currX - moveSize, currY + moveSize));
            moveSize = Math.min(x - currX, currY);
            helper(queue, visited, new Pair<>(currX + moveSize, currY - moveSize));
        }
        return false;
    }

    public void helper(Queue<Pair<Integer, Integer>> queue, Set<Pair<Integer, Integer>> set, Pair<Integer, Integer> entry){
        if (!set.contains(entry)){
            queue.add(entry);
            set.add(entry);
        }
    }
    public int gcd(int a, int b){
        while (b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}