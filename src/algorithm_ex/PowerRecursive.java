package algorithm_ex;

public class PowerRecursive {
    static int powerRecursive(int x, int index){
        if(index <= 0) return 1;

        return x * powerRecursive(x, index-1);
    }
}
