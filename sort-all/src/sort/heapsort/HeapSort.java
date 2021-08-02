package sort.heapsort;

import java.util.Arrays;

/**
 * not stability
 * @Classname HeapSort
 * @Description non
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
        // 从大到小
//        for (int i=0; i< arr.length; i++){
//            HeapCommon.heapInsert(arr, i);
//        }

        // O(n)
        // 从小到大
        // 先heapify 找到最大节点
        for (int i = arr.length - 1; i >= 0; i--) {
            HeapCommon.heapify(arr, i, arr.length);
        }

        int index = arr.length;
        // 将最大节点交换到最后 并通过index排除在下次heapify之外
        HeapCommon.swap(arr, 0, --index);
        while (index > 0) {
            // 继续heapify找到最大节点 并 交换到最后 并 将其排除在外
            HeapCommon.heapify(arr, 0, index);
            HeapCommon.swap(arr, --index, 0);
        }
    }
}
