/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * 解题思路：
 * 1.使用链表模拟整个过程。先初始化一个链表，一次添加0-n-1
 *   第一次要删去的结点是 c = (m - 1) % size
 *   下一次从这个点开始继续向后m个位置，但是注意此时链表的size 已经 减了 1
 *   所以下一次的位置是 （c + m - 1） % （size - 1）
 *   重复进行这个操作直到链表中只剩下一个元素，返货list.get(0)即可。
 * 2.数学方法：约瑟夫环
 *   首先，记f(n)为游戏结束后最后一个数字的index，那么关键在于找到f(n,start=0)和f(n-1,start=0)的关系。
 *   显然，第一次扔出去的元素是(m-1)%n，记作k，那么根据游戏规则f(n,start=0)=f(n-1,start = k+1)。
 *   接下来我们可以看到f(n-1,start = k+1) = (f(n-1,start=0)+k+1)%n。
 *   有了这个中间桥梁，可知f(n,start=0) = (f(n-1,start=0)+k+1)%n = (f(n-1,start=0)+m)%n。然后从f(1)=0推广过去即可。
 * 作者：jichenyeung
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/python3kan-bu-dong-ni-gen-wo-xing-by-jichenyeung/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
// 链表模拟
class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> l = new ArrayList<>();
        for ( int i = 0;i < n; i ++){
            l.add(i);
        }
        int c = (m - 1) % n;
        while (l.size() != 1){
            l.remove(c);
            c = (c + m - 1) % l.size();
        }
        return l.get(0);
    }
}

// 约瑟夫环
class Solution {
    public int lastRemaining(int n, int m) {
        int c = 0;
        for (int i = 2; i <= n; i ++){
            c = (c + m) % i;
        }
        return c;
    }
}