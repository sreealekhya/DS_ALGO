package matrix;

/**
 * Given a boolean 2D matrix, find the number of islands.
 * A group of connected 1s forms an island. For example, the below matrix contains 5 islands

 Example:

 Input : mat[][] = {{1, 1, 0, 0, 0},
 {0, 1, 0, 0, 1},
 {1, 0, 0, 1, 1},
 {0, 0, 0, 0, 0},
 {1, 0, 1, 0, 1}
 Output : 5
 This is a variation of the standard problem: “Counting the number of connected components in an undirected graph”.
 */
public class NumberOfIslands {

    public static void main (String[] args) throws java.lang.Exception
    {
        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1}
        };
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println("Number of islands is: "+ numberOfIslands.countIslands(M));
    }


    int countIslands(int[][] M) {
        int count = 0;
        int[][] visited = new int[M.length][M[0].length];
        for(int i=0;i<M.length;i++) {
            for(int j=0;j<M[i].length;j++) {
                if(M[i][j] == 1 && visited[i][j]==0) {
                    count++;
                    DFS(M,visited,i,j);
                }
            }
        }
        return count;
    }


    void DFS(int[][] mat, int[][] visited,int i,int j) {
        visited[i][j] =1;
        int[] rowDiff = {-1,-1,-1,0,0,1,1,1};
        int[] colDiff = {-1,0,1,-1,1,-1,0,1};

        for(int d=0;d<8;d++) {
            if(i+rowDiff[d]>=0 && i+rowDiff[d]<mat.length
                    && j+colDiff[d]>=0 && j+colDiff[d]<mat[0].length
                    && mat[i+rowDiff[d]][j+colDiff[d]]==1
                    && visited[i+rowDiff[d]][j+colDiff[d]] == 0) {
                DFS(mat,visited,i+rowDiff[d],j+colDiff[d]);
            }
        }
    }
}
