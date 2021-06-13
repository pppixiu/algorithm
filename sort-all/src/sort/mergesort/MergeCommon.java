package sort.mergesort;

/**
 * @Classname Common
 * @Description TODO
 * @Date 2021/5/29 10:41 下午
 * @Created by apple
 */
public class MergeCommon {
    public static void doMerge1(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int cur = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            temp[cur++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= m) {
            temp[cur++] = arr[p1++];
        }

        while (p2 <= r) {
            temp[cur++] = arr[p2++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[l + i] = temp[i];
        }
    }

    public static void doMerge2(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int cur = 0;
        int p1 = l;
        int p2 = m + 1;

        while (cur < temp.length) {
            if (p1 > m) {
                temp[cur++] = arr[p2++];
            } else if (p2 > r) {
                temp[cur++] = arr[p1++];
            } else {
                temp[cur++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
            }
        }

        for (int i = 0; i < temp.length; i++) {
            arr[l + i] = temp[i];
        }
    }
}
