package sort.heapsort;

import java.util.zip.Inflater;

/**
 * @Classname HeapCommon
 * @Description TODO
 * @Date 2021/6/10 10:41 下午
 * @Created by apple
 */
public class HeapCommon {

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }


    public static void heapify(int[] arr, int index, int heapSize) {
        int l = index * 2 + 1;
        while (l < heapSize) {
            int largest = l + 1 < heapSize && arr[l + 1] > arr[l] ? l + 1 : l;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }

            swap(arr, largest, index);
            index = largest;
            l = index * 2 + 1;
        }
    }


    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
