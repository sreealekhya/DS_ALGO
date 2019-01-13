package array;

/**
 * Created by Sreemani Alekhya on 04/01/19.
 */
public class FindElemInSortedRotatedArray {

    public static void main(String[] args) {
        FindElemInSortedRotatedArray findElemInSortedRotatedArray = new FindElemInSortedRotatedArray();

        int[] arr = {1,2};

        System.out.println(findElemInSortedRotatedArray.find(arr,4));

    }


    int find(int[] arr, int elem) {


        int index = findRotationPt(arr,elem,0,arr.length-1);

        return index;
    }


    int findRotationPt(int[] arr, int elem,int low,int high){
        if(low<high) {
            int mid = (low+high)/2;
            if(mid!=0){

                if(arr[mid]<arr[mid-1]) return mid;

            }
            if(mid!=arr.length-1)
                if(arr[mid]>arr[mid+1]) return mid+1;

            if(arr[low]>arr[mid]) return findRotationPt(arr,elem,low,mid-1);
            return findRotationPt(arr,elem,mid+1,high);
        }
        else
        {
            return 0;
        }
    }
}
