package array;

/**
 *Write an efficient program to find the sum of contiguous subarray
 * within a one-dimensional array of numbers which has the largest sum.
 */
public class LargestContiguousSubArraySum {
    public static void main(String[] args) {
        int[] arr = {1,2,-4,2,4,5};
        LargestContiguousSubArraySum largestContiguousSubArraySum = new LargestContiguousSubArraySum();
        int sum  = largestContiguousSubArraySum.LCSubarraySum(arr);
        System.out.println(sum);
    }

    int LCSubarraySum(int[] arr) {
        int max_so_far = Integer.MIN_VALUE;

        int current_sum = arr[0];

        for(int i =1;i<arr.length;i++) {
            current_sum = Math.max(arr[i],current_sum+arr[i]);
            max_so_far = Math.max(max_so_far,current_sum);
        }
        return max_so_far;
    }
}
