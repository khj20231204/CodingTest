package algorithm_ex;

public class FibonacciRecursive {
    static int fibonacciRecursive(int n){

        if(n==1 || n==2) return 1;

        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }
}
