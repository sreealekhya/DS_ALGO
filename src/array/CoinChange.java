package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a value N, if we want to make change for N cents,
 * and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 * how many ways can we make the change? The order of coins doesn’t matter.
 For example, for N = 4 and S = {1,2,3},
 there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 So the output should be 5.
 */
public class CoinChange {

    public static void main(String[] args) {

        int[] S = {2, 5, 3, 6};

        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.countAllPossibilities(S, 10));

        int[] S1 = {1,2,  3};

        coinChange.printAllCombs(S1,4);


    }


    int countAllPossibilities(int[] arr, int sum) {
        int[][] mat = new int[sum+1][arr.length+1];

        //sum =0 with no empty subarray
        for(int i=0;i<arr.length+1;i++) {
            mat[0][i] =1;
        }


        for(int i =1;i<=sum;i++) {
            for(int j =1;j<=arr.length;j++) {
                mat[i][j] = mat[i][j-1];

                if(arr[j-1]<=i){
                    mat[i][j] +=mat[i-arr[j-1]][j];
                }
            }
        }

        return mat[sum][arr.length];

    }

    void printAllCombs(int[] arr, int sum) {
        int[][] mat = new int[sum+1][arr.length+1];

        //sum =0 with no empty subarray
        for(int i=0;i<arr.length+1;i++) {
            mat[0][i] =1;
        }


        for(int i =1;i<=sum;i++) {
            for(int j =1;j<=arr.length;j++) {
                mat[i][j] = mat[i][j-1];

                if(arr[j-1]<=i){
                    mat[i][j] +=mat[i-arr[j-1]][j];
                }
            }
        }

        if(mat[sum][arr.length]>0) printAllSubs(mat,new ArrayList<Integer>(),arr.length-1,sum,arr);
    }


    void printAllSubs(int[][] mat, List<Integer> al, int index,int sum, int[] arr) {
        if(index==0 && sum ==0) {
            //print
            for(Integer a : al){
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        if(index==0 && sum>0 && mat[sum-arr[index]][0]>0) {
            //print
            al.add(arr[0]);
            for(Integer a : al){
                System.out.print(a + " ");
            }
            System.out.println();
            al.remove(al.size()-1);
            return;
        }


        /*if(sum>=arr[index] && mat[sum][index+1]-mat[sum-arr[index]][index+1]>0) {
            printAllSubs(mat,al,index-1,sum,arr);
        }*/

        if(mat[sum][index]>0)
            printAllSubs(mat,al,index-1,sum,arr);

        if(sum>=arr[index] && mat[sum-arr[index]][index+1]>0) {
            al.add(arr[index]);
            printAllSubs(mat,al,index,sum-arr[index],arr);
            al.remove(al.size()-1);
        }




    }
}
