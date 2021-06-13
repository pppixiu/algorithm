package sort.quicksort;

import sort.SortHelper;

import java.util.Stack;

/**
 * @Classname QuickSortNormal
 * @Description non
 * @Date 2021/6/14 12:45 上午
 * @Created by apple
 */
public class QuickSortNormal {

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
        Stack<Job> stack = new Stack<>();
        stack.push(new Job(0, arr.length - 1));
        while (!stack.isEmpty()) {
            Job cur = stack.pop();
            int[] equals = QuickSortCommon.partition(arr, cur.l, cur.r);
            if (equals[0] > cur.l) { // 有< 区域
                stack.push(new Job(cur.l, equals[0] - 1));
            }
            if (equals[1] < cur.r) { // 有 > 区域
                stack.push(new Job(equals[1] + 1, cur.r));
            }
        }
    }

    public static class Job {
        public int l;
        public int r;

        public Job(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
