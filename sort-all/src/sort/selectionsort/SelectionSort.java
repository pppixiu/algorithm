package sort.selectionsort;

import sort.SortHelper;

/**
 * not stability
 *
 * @Classname SelectionSort
 * @Description non
 * @Date 2021/6/13 5:25 下午
 * @Created by apple
 */
public class SelectionSort {
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

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                swap(arr, i, min);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
