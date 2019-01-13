package backtracking;

/**
 * Created by Sreemani Alekhya on 03/01/19.
 */
public class NQueens {

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        int row_col_no = 4;
        System.out.println(nQueens.place(row_col_no));
    }

    boolean place(int row_col_no) {
        int[][] placed = new int[row_col_no][row_col_no];
        return isItPossible(0,row_col_no,placed);
    }

    boolean isItPossible(int col,int maxColRow, int[][] placed) {
        if(col>=maxColRow) return true;

        for(int i=0;i<maxColRow;i++) {
            if(isSafe(i,col,placed,maxColRow))
            {
                placed[i][col] =1;
                if(isItPossible(col+1,maxColRow,placed)) return true;
            }

            placed[i][col]= 0;
        }

       return false;
    }

    boolean isSafe(int row,int col,int[][] placed, int maxRow) {
        for(int i = 0;i<col;i++) {
            if(placed[row][i]==1) return false;
        }

        int r  =row-1;
        for(int i=col-1;i>=0 && r>=0;i--, r--){
            if(placed[r][i]==1) return false;
        }
        r = row+1;
        for(int i = col-1;i>=0&&r<maxRow;i--,r++) {
            if(placed[r][i]==1) return false;
        }

        return true;
    }
}
