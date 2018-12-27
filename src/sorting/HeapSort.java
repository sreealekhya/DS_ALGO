package sorting;

public class HeapSort {

    public static void main(String[] args) {

        int[] arrayToSort = {4, 1, 5, 0, 2, 9, 0};

        HeapSort hs = new HeapSort();

        int[] sortedArray = hs.sort(arrayToSort, 0, arrayToSort.length);


        for (int elementOfArray : sortedArray) {
            System.out.println(elementOfArray);
        }
    }


    int[] sort(int[] arr, int start, int end){
        for(int i = end/2 - 1; i>=0;i--) {
            heapify(arr,end,i);
        }

        for(int i = end-1;i>=0;i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i]= temp;

            heapify(arr,i,0);
        }

        return arr;

    }


    int[] heapify(int[] arr, int size, int start) {

        int largest = start;
        int left = 2*start+1;
        int right = 2*start+2;

        if(left<size && arr[left]>arr[largest]) {
            largest = left;
        }

        if(right<size && arr[right]>arr[largest]) {
            largest = right;
        }

        if(largest!=start) {
            int temp = arr[largest];
            arr[largest] = arr[start];
            arr[start] = temp;

            heapify(arr,size,largest);
        }
        return arr;
    }

}
