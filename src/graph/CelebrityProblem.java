package graph;

import java.util.Stack;

/*
In a party of N people, only one person is known to everyone.
Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party.
We can only ask questions like “does A know B? “. Find the stranger (celebrity) in minimum number of questions.

We can describe the problem input as an array of numbers/characters
representing persons in the party. We also have a hypothetical function
HaveAcquaintance(A, B) which returns true if A knows B, false otherwise. How can we solve the problem.
 */
public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] mat= { { 0, 0, 1, 0 },
                       { 0, 0, 1, 0 },
                       { 0, 0, 0, 0 },
                       { 0, 0, 1, 0 } };


        CelebrityProblem celebrityProblem = new CelebrityProblem();
        System.out.print(celebrityProblem.findCelebrity(mat));



    }


    int findCelebrity(int[][] mat) {
        int start = 0;
        int end = mat.length-1;

        while(start!=end) {
            if(mat[start][end] == 1) {
                start++;
            }
            else {
                end--;
            }
        }

        int count =0;
        for(int i=0;i<mat.length;i++) {
            if(i!=start && mat[i][start]==1 && mat[start][i]==0) {
                count++;
            }
        }

        if(count == mat.length-1)
            return start;

        else return -1;


    }

}
