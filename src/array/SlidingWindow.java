package array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
 Examples :

 Input :
 arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
 k = 3
 Output :
 3 3 4 5 5 5 6
 */
public class SlidingWindow {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 0, 5, 2, 3, 6};
        SlidingWindow sw = new SlidingWindow();
        int k = 3;

        Integer[] result = sw.findMaxElements(arr,k);

        for(int element: result) {
            System.out.println(element);
        }
    }

    Integer[] findMaxElements(int[] arr, int k) {
        Deque<Integer> slidingMaxElementsSlide = new LinkedList<>();
        Integer[] resultArray = new Integer[arr.length-2];

        int j =0;
        int i = 0;
        int resultInd = 0;

        while(i<arr.length){
            if(j==k) {

                int max = slidingMaxElementsSlide.peekFirst();
                resultArray[resultInd] = arr[max];
                resultInd++;
                if(slidingMaxElementsSlide.peekFirst()<=i-k){
                    slidingMaxElementsSlide.removeFirst();
                }
                j=k-1;

            }
            while(!slidingMaxElementsSlide.isEmpty() && arr[slidingMaxElementsSlide.peek()]< arr[i]) {
                slidingMaxElementsSlide.removeLast();
            }

            slidingMaxElementsSlide.addLast(i);

            i++;
            j++;
        }

        if(j==k) {

            int max = slidingMaxElementsSlide.peekFirst();
            resultArray[resultInd] = arr[max];
            resultInd++;

        }

        return resultArray;
    }

}

