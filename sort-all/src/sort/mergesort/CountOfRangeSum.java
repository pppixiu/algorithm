package sort.mergesort;

/**
 * @Classname CountOfRangeSum
 * @Description non
 * @Date 2021/6/6 12:19 上午
 * @Created by apple
 */
public class CountOfRangeSum {

    public static void main(String[] args) {

//        int[] nums = new  int[]{-2,5,-1};
//        System.out.println(countRangeSum(nums, -2, 2));
//
//        int[] nums2 = new  int[]{0, 0};
//        System.out.println(countRangeSum(nums2, 0, 0));
//
//        int[] nums3 = new  int[]{-1,1};
//        System.out.println(countRangeSum(nums3, 0, 0));
//
//        int[] nums4 = new  int[]{2147483647,-2147483648,-1,0};
//        System.out.println(countRangeSum(nums4, -1, 0));


//        int[] nums5 = new  int[]{-2,0,-2,-3,2,2,1,-3,4};
//        System.out.println(countRangeSum(nums5, 4, 11));

        int[] nums6 = new  int[]{-2147483647,0,-2147483647,2147483647};
        System.out.println(countRangeSum(nums6, -564, 3864));


    }

    public static int countRangeSum(int[] nums, int lower, int upper) {

        int[] sum = new int[nums.length];
        int res = 0;
        for(int i=0; i< nums.length; i++){
            res = res + nums[i];
            sum[i] = res;
        }

        return process(sum, 0, sum.length-1, lower, upper);
    }

    private static int process(int[] nums, int l, int r, int lower, int upper){
        if(l == r ){
            return nums[l] >= lower && nums[l] <= upper  ? 1:0;
        }

        int middle = l +(r-l) /2;
        int left = process(nums, l, middle, lower, upper);
        int right = process(nums, middle +1, r, lower, upper);
        int merge = merge(nums, l, middle, r, lower, upper);

        return left + right + merge;
    }


    private static int merge(int[] nums, int l, int m, int r, int lower, int upper){

        int result = 0;
        int tIndex = m+1;
        int tLIndex = l;
        int tRIndex = l;
        while(tIndex <= r){
            int newLower = nums[tIndex] - upper;
            int newUpper = nums[tIndex] - lower;
            while(tLIndex <= m && nums[tLIndex] < newLower){
                tLIndex++;
            }
            while(tRIndex <= m && nums[tRIndex] <= newUpper ){
                tRIndex ++;
            }

            result +=  tRIndex - tLIndex;
            tIndex++;
        }

        // 归并排序
        int lIndex = l;
        int rIndex = m+1;
        int index = 0;
        int temp[] = new int[r-l+1];
        while(lIndex <= m && rIndex <=r ){
            temp[index++] = nums[lIndex] <= nums[rIndex] ? nums[lIndex++] : nums[rIndex++];
        }

        while(lIndex <= m){
            temp[index++] = nums[lIndex++];
        }

        while(rIndex <= r){
            temp[index++] = nums[rIndex++];
        }

        for(int i=0; i< temp.length; i++){
            nums[l+i] = temp[i];
        }

        return result;
    }
}
