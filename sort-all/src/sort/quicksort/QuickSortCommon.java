package sort.quicksort;

/**
 * @Classname QuickSortCommon
 * @Description non
 * @Date 2021/6/14 12:46 上午
 * @Created by apple
 */
public class QuickSortCommon {
    /**
     * at the range of [l,r]
     * partition by arr[r]
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static int[] partition(int[] arr, int l, int r) {
        int borderL = l - 1;
        int borderR = r;
        int index = l;
        while (index < borderR) {
            if (arr[index] < arr[r]) {
                swap(arr, index++, ++borderL);
            } else if (arr[index] > arr[r]) {
                swap(arr, index, --borderR);
            } else {
                index++;
            }
        }
        swap(arr, borderR, r);
        return new int[]{borderL + 1, borderR};
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
