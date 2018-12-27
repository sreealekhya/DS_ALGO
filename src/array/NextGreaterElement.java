package array;

import java.util.Stack;

/**
 *
 Given an array, print the Next Greater Element (NGE) for every element.
 The Next greater Element for an element x is the first greater element on the right side of x in array.
 Elements for which no greater element exist, consider next greater element as -1.

 Examples:
 a) For any array, rightmost element always has next greater element as -1.
 b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
 c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.

 Element       NGE
 4      -->   5
 5      -->   25
 2      -->   25
 25     -->   -1
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {25,2,1};
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++) {
            if(!stack.isEmpty() && stack.peek()> arr[i]) {
                stack.push(arr[i]);
                continue;
            }

            if(stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }

            while(!stack.isEmpty() && stack.peek()<arr[i]) {
                System.out.println(stack.pop() + " --> " + arr[i]);
            }
            stack.push(arr[i]);
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop() + " --> " + -1);
        }


    }
}
