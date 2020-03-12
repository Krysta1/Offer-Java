/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 解题思路：
 * 1.直接求出要输出的最大值，新建一个数组，使用一个循环一次将1-10^n-1存放到数组中即可。
 * 2.但是如果出现大数问题，方法1中的代码是无法解决的。所以使用数组存放结果来解决这一问题。
 */
class Solution {
    public int[] printNumbers(int n) {
//        int range = 0;
//        int base = 1;
//        for (int i = 0; i < n; i ++){
//            range += 9 * base;
//            base *= 10;
//        }
        int range = (int)Math.pow(10, n) - 1;
        System.out.println(range);
        int[] res = new int[range];
        for(int i = 0; i < range; i ++){
            res[i] = i + 1;
        }
        return res;
    }
}

class Solution {
    StringBuilder sb;
    int idx = 0;
    public boolean increment(int n){
        boolean carry=false;
        for(int i=0;i<sb.length();++i){
            if(carry || i==0){
                if(sb.charAt(i)=='9'){
                    sb.setCharAt(i,'0');
                    carry = true;
                }else{
                    sb.setCharAt(i,(char) (sb.charAt(i)+1));
                    carry = false;
                }
            }else{
                break; // no addition on last idx, no need to compute any more
            }
        }
        if(carry){
            sb.append("1");
        }
        return sb.length()<=n; // overflow!
    }

    public void save(int ans[]){
        ans[idx] = Integer.parseInt(sb.reverse().toString());
        sb.reverse();
    }

    public int[] printNumbers(int n) {
        int[] ans = new int[(int) Math.pow(10,n) - 1];
        sb = new StringBuilder("0");
        while(increment(n)){
            save(ans);
            idx++;
        }
        return ans;
    }
}

//作者：forsworns
//链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/javaliang-chong-ti-jie-kuai-su-mi-da-shu-jia-fa-by/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

