/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 解题思路：
 * 1.直接使用Java库函数，Arrays.sort()，然后返回前k个数。
 * 2.昨天有点懒直接用库解决问题了，今天仔细品品这道题。
 *      1.使用快排的思想，解决Top K问题。因为在一次partition之后，就会有一个元素排到他应该在的位置。在这个元素之前的所有元素都是
 *      小于这个元素的。之后都是大于这个元素。对于Top K问题可以直接进行partition操作直到返回的索引值是k-1也就是第k小的数。此时前面
 *      的所有数（包含k-1）就是最小的Top k个数。
 *      2.使用大根堆，维护一个容量为K的大根堆，最后全部遍历结束之后，大根堆里保存的就是最小的K个数。
 *      Java中有现成的PrioriQueue实现。
 *      3.使用计数排序。
 */
// 直接使用库函数
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i ++){
            res[i] = arr[i];
        }
        return res;
    }
}

// 快排思想
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        return quickSort(arr, 0, arr.length - 1, k - 1);
    }

    public int[] quickSort(int[] arr, int l, int r, int k){
        int j = partition(arr, l, r);
        if (j == k) return Arrays.copyOf(arr, j + 1);
        return j > k ? quickSort(arr, l, j - 1, k) : quickSort(arr, j + 1, r, k);
    }

    public int partition(int[] arr, int l, int r){
        int tmp = arr[l];
        int i = l, j = r + 1;
        while (true){
            while(++i <= r && arr[i] < tmp);
            while(--j >= l && arr[j] > tmp);
            if (i >= j) break;
            int k = arr[i];
            arr[i] = arr[j];
            arr[j] = k;
        }
        arr[l] = arr[j];
        arr[j] = tmp;
        return j;
    }
}
// 大根堆
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        int[] res = new int[k];
        for (int i = 0; i < arr.length; i ++){
            if (pq.size() < k){
                pq.offer(arr[i]);
            }
            else if (arr[i] < pq.peek()){
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i ++){
            res[i] = pq.poll();
        }
        return res;
    }
}

// 计数排序
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        int[] res = new int[k];

        int[] count = new int[10001];
        for (int num: arr){
            count[num] ++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i ++){
            while(count[i]-- > 0 && index < k){
                res[index++] = i;
            }
            if (index == k){
                break;
            }
        }
        return res;

    }
}

