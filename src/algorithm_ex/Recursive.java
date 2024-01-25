package algorithm_ex;

public class Recursive {
    static void recursive(int num){

        if(num <= 0) return;

        System.out.println(num + " before recursive");
        recursive(num-1);
        System.out.println(num + " after recursive");
    }
}
