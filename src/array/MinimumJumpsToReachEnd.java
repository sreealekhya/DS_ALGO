package array;

/**
 * Created by Sreemani Alekhya on 01/01/19.
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element. Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then we cannot move through that element.

 Examples:

 Input :  arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 Output :  3 (1-> 3 -> 8 -> 9)
 */
public class MinimumJumpsToReachEnd {

    public static void main(String[] args) {
        //int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] arr = {2,0,1,0 ,4};
        MinimumJumpsToReachEnd minimumJumpsToReachEnd = new MinimumJumpsToReachEnd();
        System.out.println(minimumJumpsToReachEnd.count(arr));
    }

    int count(int[] arr) {

        if(arr.length<=1) return 0;

        if(arr[0]==0) return -1;
        int max_val = arr[0];

        int max_reach = arr[0];

        int jumps =1;



        for(int i=1;i<arr.length-1;i++) {
            max_reach--;
            max_val = Math.max(max_val,i+arr[i]);


            if(max_reach==0) {
                jumps++;

                if(i == max_val)
                {
                    return -1;
                }

                max_reach = max_val-i;
            }

        }


        return jumps;
    }
}
