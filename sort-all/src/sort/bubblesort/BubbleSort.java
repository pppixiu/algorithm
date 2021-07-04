package sort.bubblesort;

import sort.SortHelper;

/**
 * stability
 *
 * @Classname BubbleSort
 * @Description non
 * @Date 2021/6/13 5:25 下午
 * @Created by apple
 */
public class BubbleSort {

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

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
