package array;

/**
 *
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {4,9,10,7,5,6,8};
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        int res = longestIncreasingSubsequence.LIS(arr);
        System.out.println(res);
    }


    private int LIS(int[] arr) {

         int[] outArr = new int[arr.length];
         for(int i=0;i<arr.length;i++) {
             outArr[i] =1;
             for(int j = 0;j<i;j++) {
                 if(arr[j]<arr[i] && outArr[j]+1> outArr[i]) {
                     outArr[i] = outArr[j]+1;
                 }
             }
         }
         int res = Integer.MIN_VALUE;

         for(int i=0;i<arr.length;i++) {
             if(res< outArr[i]) {
                 res = outArr[i];
             }

         }

         return res;

    }
}
