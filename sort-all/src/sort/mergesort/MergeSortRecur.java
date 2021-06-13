package sort.mergesort;

import sort.SortHelper;

/**
 * stability
 *
 * @Classname MergeSort
 * @Description TODO
 * @Date 2021/5/28 12:21 上午
 * @Created by apple
 */
public class MergeSortRecur {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int[] arr = SortHelper.generateArr(100, 100);
            process(arr, 0, arr.length - 1);
            SortHelper.judge(arr);
        }
    }

    public static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }

        int m = l + (r - l) / 2;
        process(arr, l, m);
        process(arr, m + 1, r);
//        Common.doMerge1(arr, l, m, r);
        MergeCommon.doMerge2(arr, l, m, r);
    }
}
