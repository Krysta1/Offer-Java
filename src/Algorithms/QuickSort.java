package Algorithms;

public class QuickSort {
    public void Quick(int[] arr){
        Sort(arr, 0, arr.length - 1);
        System.out.println(arr);
    }

    public void Sort(int[] arr, int l, int r){
        if (l > r) return;
        int j = partition(arr, l, r);
        Sort(arr, l, j - 1);
        Sort(arr, j + 1, r);
    }
    public int partition(int[] arr, int l, int r){
        int tmp = arr[l];
        int i = l, j = r + 1;
        while (true){
            while(++i <= r && arr[r] < tmp);
            while(--j >= r && arr[j] > tmp);
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
class Solution{
    public static void main(String[] args){
        QuickSort q = new QuickSort();
        q.Quick(new int[]{3, 2, 1});
    }
}




