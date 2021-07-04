package sort;

/**
 * @Classname Help
 * @Description non
 * @Date 2021/5/29 10:29 下午
 * @Created by apple
 */
public class SortHelper {
    public static int[] generateArr(int maxSize, int maxValue) {
        int arr[] = new int[(int) ((maxSize + 1) * Math.random())];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random() - maxValue * Math.random());
        }
        return arr;
    }

    public static int[] generatePositiveArr(int maxSize, int maxValue) {
        int arr[] = new int[(int) ((maxSize + 1) * Math.random())];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    public static void judge(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                throw new RuntimeException("algorithm error");
            }
        }

        System.out.println("success");
    }

}
