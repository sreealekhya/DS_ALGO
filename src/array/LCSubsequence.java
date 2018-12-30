package array;

/**
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.

 It is a classic computer science problem, the basis of diff
 (a file comparison program that outputs the differences between two files), and has applications in bioinformatics.

 Examples:
 LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LCSubsequence {

    public static void main(String[] args) {
        LCSubsequence lcSubsequence = new LCSubsequence();

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();

        //recursive
        System.out.println(lcSubsequence.calculate(X,Y,0,0));

        //iterative-DP
        System.out.println(lcSubsequence.calIterative(X,Y));
    }


    int calculate(char[] X, char[] Y, int m, int n )
    {
        if (m == X.length || n == Y.length)
            return 0;
        if (X[m] == Y[n])
            return 1 + calculate(X, Y, m+1, n+1);
        else
            return Math.max(calculate(X, Y, m, n+1), calculate(X, Y, m+1, n));
    }


    int calIterative(char[] X, char[] Y) {
        int[][] mat = new int[X.length+1][Y.length+1];

        for(int i=1;i<X.length+1;i++) {
            for(int j=1;j<Y.length+1;j++) {
                if(X[i-1]==Y[j-1]) {
                    mat[i][j] = 1+mat[i-1][j-1];
                }
                else {
                    mat[i][j] = Math.max(mat[i][j-1],mat[i-1][j]);
                }
            }
        }

        return mat[X.length][Y.length];
    }
}
