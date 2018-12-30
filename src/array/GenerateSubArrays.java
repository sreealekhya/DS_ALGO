package array;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.ArrayList;
import java.util.List;

/**
 * Generate Sub Arrays for a Array
 */
public class GenerateSubArrays {

    public static void main(String[] args) {
        int[] arr = {1,2};


        GenerateSubArrays generateSubArrays = new GenerateSubArrays();
        generateSubArrays.generateAll(arr);
    }

    void generateAll(int[] arr) {
        generate(arr,0,new ArrayList<>());
    }

    void generate(int[] arr, int index, List<Integer> res) {
        if(index == arr.length) {
            //print
            System.out.print("{ ");
            for(Integer integer: res) {
                System.out.print(integer+" ");
            }
            System.out.println("}");
            return;
        }


        //include
        //ArrayList<Integer> res_1 = new ArrayList<>();
        //res_1.addAll(res);
        res.add(arr[index]);
        generate(arr,index+1,res);
        res.remove(res.size()-1);

        generate(arr,index+1,res);
    }
}
