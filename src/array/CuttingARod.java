package array;

/**
 * Given a rod of length n inches and an array of prices that
 * contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * For example, if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)


 length   | 1   2   3   4   5   6   7   8
 --------------------------------------------
 price    | 1   5   8   9  10  17  17  20
 */
public class CuttingARod {

    public static void main(String[] args) {
        int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};

        CuttingARod cuttingARod = new CuttingARod();
        System.out.println(cuttingARod.getMaxPrice(arr));
    }

    int getMaxPrice(int[] arr) {
        int[] res = new int[arr.length+1];


        res[0]=0;
        if(arr.length>0)
            res[1]=arr[0];

        for(int i = 2;i<arr.length+1;i++) {
            int max_val = Integer.MIN_VALUE;
            for(int j =0;j<i;j++) {
                 max_val = Math.max(max_val,arr[j]+res[i-j-1]);
            }
            res[i] = max_val;
        }
        return res[arr.length];
    }
}
