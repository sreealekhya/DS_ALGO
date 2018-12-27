package array;


import java.util.Stack;

/*The stock span problem is a financial problem where we have a series of n daily price quotes
 for a stock and we need to calculate span of stock’s price for all n days.
        The span Si of the stock’s price on a given day i is defined as the maximum number
         of consecutive days just before the given day, for which the price of the stock
          on the current day is less than or equal to its price on the given day.
        For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
         then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
*/
public class StockAndSpan {

    public static void main(String[] args) {
        int[] arr = {2,2,2,3};
        StockAndSpan stockAndSpan = new StockAndSpan();
        int[] res = stockAndSpan.stockAndSpan(arr);

        for(int i : res) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }

    int[] stockAndSpan(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        stack.add(0);
        res[0] = 1;

        for(int i=1;i<arr.length;i++) {
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) res[i] = i+1;
            else res[i] = i-stack.peek();

            stack.push(i);

        }

        return res;
    }
}
