package array;

/**
 * The cost of a stock on each day is given in an array,
 * find the max profit that you can make by buying and selling in those days.
 * For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
 * the maximum profit can earned by buying on day 0, selling on day 3.
 * Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order,
 * then profit cannot be earned at all.
 */
public class MaxiMumProfitFromStock1 {

    public static void main(String[] args) {
        int[] arr = {100, 180, 260, 310, 40, 535, 695,41};
        int[] arr1 = {100,120,130};

        MaxiMumProfitFromStock1 maxiMumProfitFromStock1 = new MaxiMumProfitFromStock1();
        System.out.println(maxiMumProfitFromStock1.getProfit(arr1));
    }

    int getProfit(int[] arr) {
        int min_val = arr[0],max_val =arr[0];

        int slope =0;

        int res= 0;

        for(int i =1;i<arr.length;i++) {
            if(slope<0 && arr[i]>arr[i-1]){
                max_val = arr[i];
                slope=1;
            }

            else if(slope>0 && arr[i]<=arr[i-1]) {
                //max_val = arr[i-1];
                res+=max_val-min_val;
                slope= -1;
                min_val = arr[i];
            }
            else if(slope>0 && arr[i]>arr[i-1]){
                max_val = arr[i];
            }

            else if(slope<0 && arr[i]<arr[i-1]) {
                min_val= arr[i];
            }

            else if(slope==0 && arr[i]>arr[i-1]){
                max_val = arr[i];
                slope=1;
            }
            else {
                min_val = arr[i];
                slope =-1;
            }


        }

        if(slope == 1)
            res+=max_val-min_val;
        return res;

    }
}
