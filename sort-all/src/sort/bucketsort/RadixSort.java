package sort.bucketsort;

import sort.SortHelper;

/**
 * stability
 *
 * @Classname RaeixSort
 * @Description non
 * @Date 2021/6/14 1:58 下午
 * @Created by apple
 */
public class RadixSort {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int[] arr = SortHelper.generatePositiveArr(100, 100);
            sort(arr);
            SortHelper.judge(arr);
        }
    }

    public static void sort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }

        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    public static void radixSort(int[] arr, int l, int r, int digit) {
        int radix = 10;
        int i = 0;
        int j = 0;
        int[] help = new int[r - l + 1];

        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];
            for (int c = 0; c < arr.length; c++) {
                count[getDigit(arr[c], d)]++;
            }

            for (int c = 1; c < count.length; c++) {
                count[c] += count[c - 1];
            }

            for (int c = r; c >= l; c--) {
                int nowDigit = getDigit(arr[c], d);
                int position = --count[nowDigit];
                help[position] = arr[c];
            }

            for (i = l, j = 0; i <= r; i++, j++) {
                arr[i] = help[j];
            }
        }
    }

    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

}
