package sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arrayToSort = {4,1,5,8,2,9,3};

        MergeSort ms = new MergeSort();

        int[] sortedArray = ms.sort(arrayToSort, 0 , arrayToSort.length-1);


        for(int elementOfArray: sortedArray) {
            System.out.println(elementOfArray);
        }

    }

    public int[] sort(int[] arr, int start, int end) {
        if(start == end) return arr;

        int middle =  (start+end)/2;
        sort(arr,start,middle);
        sort(arr,middle+1,end);

        return merge(arr,start,middle,end);

    }


    public int[] merge(int[] arr, int start, int middle, int end) {

        int sortedArray1size = middle-start+1;
        int sortedArray2size = end-middle;

        Integer[] tempArray1ToSort = new Integer[sortedArray1size];
        Integer[] tempArray2ToSort = new Integer[sortedArray1size];


        for(int i=0;i<sortedArray1size ;i++)
        {
            tempArray1ToSort[i] = arr[start+i];
        }


        for(int i=0;i<sortedArray2size ;i++)
        {
            tempArray2ToSort[i] = arr[middle+i+1];
        }

        int pointerToTraverseTempArray1 = 0;
        int pointerToTraverseTempArray2 = 0;

        int pointerToTraverseMainArray = 0;
        while(pointerToTraverseTempArray1 < sortedArray1size && pointerToTraverseTempArray2<sortedArray2size){
            if(tempArray1ToSort[pointerToTraverseTempArray1] < tempArray2ToSort[pointerToTraverseTempArray2]){
                arr[start+pointerToTraverseMainArray] = tempArray1ToSort[pointerToTraverseTempArray1];
                pointerToTraverseTempArray1++;

            }
            else {
                arr[start+pointerToTraverseMainArray] = tempArray2ToSort[pointerToTraverseTempArray2];
                pointerToTraverseTempArray2++;
            }

            pointerToTraverseMainArray++;
        }

        while(pointerToTraverseTempArray1<sortedArray1size){
            arr[start+pointerToTraverseMainArray] = tempArray1ToSort[pointerToTraverseTempArray1];
            pointerToTraverseTempArray1++;
            pointerToTraverseMainArray++;
        }

        while(pointerToTraverseTempArray2<sortedArray2size){
            arr[start+pointerToTraverseMainArray] = tempArray2ToSort[pointerToTraverseTempArray2];
            pointerToTraverseTempArray2++;
            pointerToTraverseMainArray++;
        }


        return arr;

    }


}
