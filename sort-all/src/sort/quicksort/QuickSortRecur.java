package sort.quicksort;

import sort.SortHelper;

/**
 * not stability
 *
 * @Classname QuickSort
 * @Description non
 * @Date 2021/6/13 5:23 下午
 * @Created by apple
 */
public class QuickSortRecur {

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
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        // Compatible with worst case. like {1,2,3,4,5,6,7}
        QuickSortCommon.swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        int[] equelE = QuickSortCommon.partition(arr, l, r);
        process(arr, l, equelE[0] - 1);
        process(arr, equelE[1] + 1, r);
    }


}
