package sort.mergesort;

import sort.SortHelper;

/**
 * 普通 归并排序
 *
 * @Classname MergeSortNormal
 * @Description non
 * @Date 2021/5/29 10:39 下午
 * @Created by apple
 */
public class MergeSortNormal {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int[] arr = SortHelper.generateArr(100, 100);
            process(arr);
            SortHelper.judge(arr);
        }
    }

    public static void process(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }

        int n = arr.length;
        int mergeSize = 1;

        while (mergeSize < n) {
            int l = 0;
            while (l < n) {
                int m = l + mergeSize - 1;
                if (m >= n) {
                    break;
                }
                int r = Math.min(m + mergeSize, n - 1);
                MergeCommon.doMerge1(arr, l, m, r);
                l = r + 1;
            }
            // 防止mergeSize * 2 超出int最大值
            if (mergeSize > n / 2) {
                break;
            }
            mergeSize *= 2;
        }
    }
}
