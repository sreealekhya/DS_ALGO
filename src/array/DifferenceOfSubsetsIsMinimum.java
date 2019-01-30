package array;

/**
 * Given a set of integers, the task is to divide it into two sets S1 and S2
 * such that the absolute difference between their sums is minimum.
 If there is a set S with n elements, then if we assume Subset1
 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

 Example:





 Input:  arr[] = {1, 6, 11, 5}
 Output: 1
 Explanation:
 Subset1 = {1, 5, 6}, sum of Subset1 = 12
 Subset2 = {11}, sum of Subset2 = 11
 */
public class DifferenceOfSubsetsIsMinimum {



    public static void main(String[] args) {

        int[] arr = {1,6,11,5};
        DifferenceOfSubsetsIsMinimum differenceOfSubsetsIsMinimum = new DifferenceOfSubsetsIsMinimum();

        System.out.println(differenceOfSubsetsIsMinimum.calculate(arr));


    }

    int calculate(int[] input) {
        int sum = 0;
        for(int i=0;i<input.length;i++) {
            sum += input[i];
        }

        int resMatrix[][] = new int[sum+1][input.length+1];


        for(int i =0;i<=input.length;i++) {
            resMatrix[0][i]=1;
        }


        for(int i =1;i<=sum;i++) {
            for(int j=1;j<=input.length;j++) {
                resMatrix[i][j] = resMatrix[i][j-1];

                if(input[j-1]<=i) {
                    resMatrix[i][j] = resMatrix[i][j-1] | resMatrix[i-input[j-1]][j-1];
                }
            }
        }

        int diff = 0;

        for(int i = 0;i<=sum/2;i++) {
            if(resMatrix[i][input.length]==1) {
                diff = sum - 2*i;
            }
        }

        return diff;
    }

}
