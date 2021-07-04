package sort.insertionsort;

import sort.SortHelper;

/**
 * stability
 *
 * @Classname InsertionSort
 * @Description non
 * @Date 2021/6/13 5:25 下午
 * @Created by apple
 */
public class InsertionSort {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int[] arr = SortHelper.generateArr(100, 100);
            sort(arr);
            SortHelper.judge(arr);
        }
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
