package sort.bucketsort;

import sort.SortHelper;

/**
 * stability with sort2
 *
 * @Classname BucketSort
 * @Description non
 * @Date 2021/6/13 5:26 下午
 * @Created by apple
 */
public class CountSort {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int[] arr = SortHelper.generatePositiveArr(100, 100);
            sort2(arr);
            SortHelper.judge(arr);
        }
    }


    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }

    /**
     * stability
     * @param arr
     */
    public static void sort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }


        for (int i = 0; i < bucket.length - 1; i++) {
            bucket[i + 1] += bucket[i];
        }

        int[] help = new int[arr.length];
        for (int j = arr.length - 1; j >= 0; j--) {
            help[--bucket[arr[j]]] = arr[j];
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = help[i];
        }
    }
}
