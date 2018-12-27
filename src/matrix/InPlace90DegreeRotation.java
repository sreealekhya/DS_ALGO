package matrix;

/**
 * Given an square matrix, turn it by 90 degrees in clockwise direction without using any extra space.
 */
public class InPlace90DegreeRotation {

    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat.length;j++) {
                System.out.print(mat[i][j]+ " " );
            }
            System.out.println();
        }

        InPlace90DegreeRotation inPlace90DegreeRotation = new InPlace90DegreeRotation();

        mat = inPlace90DegreeRotation.rotateSquareMatrix(mat);

        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat.length;j++) {
                System.out.print(mat[i][j]+ " " );
            }
            System.out.println();
        }


    }

    int[][] rotateSquareMatrix(int[][] mat) {
        int N = mat.length;
        for(int i=0;i<mat.length;i++) {
            for(int j=i;j<mat.length-i-1;j++) {
                int temp = mat[N-j-1][i];
                mat[N-j-1][i] = mat[N-i-1][N-j-1];
                mat[N-i-1][N-j-1] = mat[j][N-i-1];
                mat[j][N-i-1] = mat[i][j];
                mat[i][j] = temp;

            }
        }
        return mat;
    }

}
