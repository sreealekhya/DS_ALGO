package array;

/*
Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of data.
1. The amount of petrol that every petrol pump has.
2. Distance from that petrol pump to the next petrol pump.

Calculate the first point from where a truck will be able to complete the circle
(The truck will stop at each petrol pump and it has infinite capacity).
 Expected time complexity is O(n). Assume for 1 litre petrol, the truck can go 1 unit of distance.

For example, let there be 4 petrol pumps with amount of petrol and distance
to next petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}.
The first point from where truck can make a circular tour is 2nd petrol pump.
Output should be “start = 1” (index of 2nd petrol pump).


 */

import java.util.LinkedList;
import java.util.Queue;

public class NGasStations {

    public static void main(String[] args) {
        int[] petrol = {2,1};
        int[] dist = {2,2};

        NGasStations nGasStations = new NGasStations();
        int startingPt = nGasStations.computeStartingPoint(petrol,dist);
        if(startingPt!=-1) System.out.print(startingPt);
    }


    int computeStartingPoint(int[] petrol, int[] dist) {
        int start = 0;
        int end = 1;


        int current_petrol = petrol[start] - dist[start];

        while(start!=end || current_petrol<0) {
            while(current_petrol<0 && start!=end) {
                current_petrol -= petrol[start]-dist[start];
                start = (start+1)%petrol.length;

                if(start ==0)
                    return -1;
            }

            current_petrol += petrol[end] - dist[end];

            end = (end+1)%petrol.length;

        }

        return start;



    }
}
