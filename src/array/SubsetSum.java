package array;

import java.util.ArrayList;

public class SubsetSum {

    public static void main(String[] args) {

        int[] arr = {3,4,2,5};

        SubsetSum subsetSum = new SubsetSum();
        //System.out.println(subsetSum.isSubsetSumPresent(arr,1));

        subsetSum.printAllSubsets(arr,9);



    }

    boolean isSubsetSumPresent(int[] arr, int sum) {
        int[][] mat  = new int[sum+1][arr.length+1];

        for(int i = 0;i<=arr.length;i++){
            mat[0][i] = 1;
        }

        for(int i=1;i<=sum;i++) {
            for(int j=1;j<=arr.length;j++) {
                mat[i][j] = mat[i][j-1];

                if(arr[j-1]<=i){
                  mat[i][j] = mat[i][j-1] | mat[i-arr[j-1]][j-1];
                }

            }
        }

        return mat[sum][arr.length] == 1;

    }


    void printAllSubsets(int[] arr, int sum) {

        int[][] mat  = new int[sum+1][arr.length+1];

        for(int i=0;i<=arr.length;i++) {
            mat[0][i] =1;
        }

        for(int i=1;i<=sum;i++) {
            for(int j=1;j<=arr.length;j++) {
                mat[i][j] = mat[i][j-1];

                if(arr[j-1]<=i){
                    mat[i][j] = mat[i][j-1] | mat[i-arr[j-1]][j-1];
                }
            }
        }

        if(mat[sum][arr.length]==0) return;

        printAllSubs(arr,sum,new ArrayList<Integer>(), arr.length-1, mat);


    }


    void printAllSubs(int[] arr, int sum, ArrayList<Integer> al, int index, int[][] mat) {
        if(index == 0 && sum == 0) {
            //print

            for(Integer a : al){
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        if(index ==0 && sum!=0 && mat[sum][arr[0]]==1) {
            al.add(arr[0]);
            //print
            for(Integer a : al){
                System.out.print(a + " ");
            }
            System.out.println();
            al.remove(al.size()-1);
            return;
        }


        if(mat[sum][index]==1) {
            //ArrayList<Integer> new_lis = new ArrayList<>();
            //new_lis.addAll(al);
            printAllSubs(arr,sum,al,index-1,mat);
        }

        if(sum>=arr[index] && mat[sum-arr[index]][index]==1){
            al.add(arr[index]);
            printAllSubs(arr,sum-arr[index],al,index-1,mat);
            al.remove(al.size()-1);
        }

    }
}
