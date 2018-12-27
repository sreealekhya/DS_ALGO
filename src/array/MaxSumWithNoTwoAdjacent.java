package array;

/**
 * Given an array of positive numbers, find the maximum sum of a subsequence
 * with the constraint that no 2 numbers in the sequence should be adjacent in the array.
 * So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
 */
public class MaxSumWithNoTwoAdjacent {

    public static void main(String[] args) {
        int[] arr = {3,2,7,10};
        MaxSumWithNoTwoAdjacent maxSumWithNoTwoAdjacent = new MaxSumWithNoTwoAdjacent();
        int sum = maxSumWithNoTwoAdjacent.getMaxSum(arr);
        System.out.println(sum);

    }

    int getMaxSum(int[] arr) {
        int incl = arr[0];
        int excl = 0;

        for(int i=1;i<arr.length;i++) {
            int temp = incl;
            incl = excl + arr[i];
            excl = Math.max(temp,excl);

        }

        return Math.max(incl,excl);

    }
}
