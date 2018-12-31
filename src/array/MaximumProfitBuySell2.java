package array;

/**
 In a daily share trading, a buyer buys shares in the morning and sells it on same day.
 If the trader is allowed to make at most 2 transactions in a day, where as second transaction
 can only start after first one is complete (Sell->buy->sell->buy). Given stock prices throughout day,
 find out maximum profit that a share trader could have made.

 Examples:

 Input:   price[] = {10, 22, 5, 75, 65, 80}
 Output:  87
 Trader earns 87 as sum of 12 and 75
 Buy at price 10, sell at 22, buy at 5 and sell at 80

 Input:   price[] = {2, 30, 15, 10, 8, 25, 80}
 Output:  100
 Trader earns 100 as sum of 28 and 72
 Buy at price 2, sell at 30, buy at 8 and sell at 80

 Input:   price[] = {100, 30, 15, 10, 8, 25, 80};
 Output:  72
 Buy at price 8 and sell at 80.

 Input:   price[] = {90, 80, 70, 60, 50}
 Output:  0
 Not possible to earn.Created by apoorvagoddanti on 31/12/18.
 */
public class MaximumProfitBuySell2 {

    public static void main(String[] args) {

        int[] arr = {10, 22, 5, 75, 65, 80};
        int[] arr1 = {10, 22, 65, 80};

        MaximumProfitBuySell2 maximumProfitBuySell2 = new MaximumProfitBuySell2();
        System.out.println(maximumProfitBuySell2.getProfit(arr));

    }

    int getProfit(int[] arr) {
        int[] profit = new int[arr.length];

        int max_val =arr[arr.length-1];

        for(int i = arr.length-2;i>=0;i--) {
            if(arr[i]>max_val) {
                max_val = arr[i];
            }
            profit[i] = Math.max(profit[i+1],max_val-arr[i]);
        }
        // return profit[0] for atmost once buying
        //return profit[0];

        int min_val = arr[0] ;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min_val){
                min_val=arr[i];
            }
            if(i!=arr.length-1)
                profit[i] = Math.max(profit[i-1],profit[i+1] + arr[i]-min_val);
            else
                profit[i] = Math.max(profit[i-1],arr[i]-min_val);
        }

        return profit[arr.length-1];
    }
}
