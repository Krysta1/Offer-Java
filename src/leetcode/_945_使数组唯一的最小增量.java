import java.util.Arrays;

/**
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 *
 * 解题思路：
 * 1.使用数组统计数字出现次数，然后遍历统计count的数组，如果>1，则把多于1的部分加个下一个数。
 *   但是需要找到最大的数，在所以大于max之后，出现count=1的情况，循环结束。
 *   一开始把数组初始化成40001，但是会出现数据量很大的情况，这时候到40001的时候count还是>1的情况
 *   干脆就把数组扩大成400001，有点取巧。并且用到排序，时间复杂度不是很好
 *   官方题解的计数方式要更好一点：思维巧妙了点，但是效率好像没有什么提升。
 *   token用来标记出现重复数据的次数，
 * 2.感觉线性探查加上路径压缩挺有意思的。
 */
class Solution {
    public int minIncrementForUnique(int[] A) {
        if (A.length == 0) return 0;
        int[] count = new int[400001];
        for (int num: A){
            count[num]++;
        }
        Arrays.sort(A);
        int max = A[A.length-1];
        int res = 0;
        for (int i = 0; i < count.length - 1; i ++) {

            if (count[i] > 1) {
                res += (count[i] - 1);
                count[i + 1] += (count[i] - 1);
            }
            if (i >= max && count[i] == 1) break;
        }
        // 官方题解的计数方式
//        int ans = 0, taken = 0;
//
//        for (int x = 0; x < 80000; ++x) {
//            if (count[x] >= 2) {
//                taken += count[x] - 1;
//                ans -= x * (count[x] - 1);
//            }
//            else if (taken > 0 && count[x] == 0) {
//                taken--;
//                ans += x;
//            }
//        }
        return res;
    }
}

// 线性探查+路径压缩
class Solution {
    int[] pos = new int [80000];
    public int minIncrementForUnique(int[] A) {
        Arrays.fill(pos, -1); // -1表示空位
        int move = 0;
        // 遍历每个数字a对其寻地址得到位置b, b比a的增量就是操作数。
        for (int a: A) {
            int b = findPos(a);
            move += b - a;
        }
        return move;
    }

    // 线性探测寻址（含路径压缩）
    private int findPos(int a) {
        int b = pos[a];
        // 如果a对应的位置pos[a]是空位，直接放入即可。
        if (b == -1) {
            pos[a] = a;
            return a;
        }
        // 否则向后寻址
        // 因为pos[a]中标记了上次寻址得到的空位，因此从pos[a]+1开始寻址就行了（不需要从a+1开始）。
        b = findPos(b + 1);
        pos[a] = b; // 寻址后的新空位要重新赋值给pos[a]哦，路径压缩就是体现在这里。
        return b;
    }
}


//作者：sweetiee
//链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/solution/ji-shu-onxian-xing-tan-ce-fa-onpai-xu-onlogn-yi-ya/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。