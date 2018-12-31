package array;

/**
 *Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 Examples :

 Input : X = "GeeksforGeeks", y = "GeeksQuiz"
 Output : 5
 The longest common substring is "Geeks" and is of
 length 5.

 Input : X = "abcdxyz", y = "xyzabcd"
 Output : 4
 The longest common substring is "abcd" and is of
 length 4.

 Input : X = "zxabcdezy", y = "yzabcdezx"
 Output : 6
 The longest common substring is "abcdez" and is of
 length 6.
 */
public class LongestCommonSubString {

    public static void main(String[] args){
        String s1 = "ALEKHYA";

        String s2 = "EEKEKH";


        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        LongestCommonSubString longestCommonSubString = new LongestCommonSubString();
        System.out.println(longestCommonSubString.LCS(arr1,arr2));

    }

    int LCS(char[] arr1, char[] arr2) {
        int[][] mat = new int[arr1.length+1][arr2.length+1];
        int max_val =0;
        for(int i=1;i<arr1.length+1;i++) {
            for(int j=1;j<arr2.length+1;j++) {
                if(arr1[i-1]==arr2[j-1]) {
                    mat[i][j] =1+mat[i-1][j-1];

                    if(max_val<mat[i][j]) {
                        max_val = mat[i][j];
                    }
                }
            }
        }
        return max_val;


    }
}
