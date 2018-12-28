package matrix;

/**
 * Given a 2D array, print it in spiral form. See the following examples.

 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int a[][] = { {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.spiralPrint(a);
    }

    void spiralPrint(int[][] a) {
        int r1=0,c1=0;

        int r2 = a.length;
        int c2=a[0].length;


        //&& here is imp
        while(r1<r2 && c1<c2) {
            for(int i= c1;i<c2;i++) {
                System.out.println(a[r1][i]);
            }

            r1++;

            for(int i=r1;i<r2;i++){
                System.out.println(a[i][c2-1]);
            }
            c2--;

            if(r1<r2) {
                for(int i = c2-1;i>=c1;i--) {
                    System.out.println(a[r2-1][i]);
                }
                r2--;
            }

            if(c1<c2) {
                for(int i=r2-1;i>=r1;i--){
                    System.out.println(a[i][c1]);
                }
                c1++;
            }

        }


    }

}
