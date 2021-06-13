package sort.heapsort;

import java.util.Arrays;

/**
 * not stability
 * @Classname HeapSort
 * @Description TODO
 * @Date 2021/6/11 12:15 上午
 * @Created by apple
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 7, 1, 0, 3, 5, 6, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // O(N*logN)
//        for (int i=0; i< arr.length; i++){
//            HeapCommon.heapInsert(arr, i);
//        }

        // O(n)
        for (int i = arr.length - 1; i >= 0; i--) {
            HeapCommon.heapify(arr, i, arr.length);
        }

        int index = arr.length;
        HeapCommon.swap(arr, 0, --index);
        while (index > 0) {
            HeapCommon.heapify(arr, 0, index);
            HeapCommon.swap(arr, --index, 0);
        }
    }
}
