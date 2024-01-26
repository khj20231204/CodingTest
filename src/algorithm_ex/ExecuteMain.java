package algorithm_ex;

import java.util.*;

import java.lang.module.ResolutionException;

public class ExecuteMain {

    public static void main(String[] args){
        //Recursive.recursive(5);
        //System.out.println(PowerRecursive.powerRecursive(3, 4));
        //System.out.println(EuclideanRecursive.euclideanRecursive(30,96));
        //System.out.println(FibonacciRecursive.fibonacciRecursive(7));

        Random r = new Random();
        int max = 20;
        int[] array = new int[max];

        for(int i=0 ; i<max ; i++){
            array[i] = r.nextInt(1,10);
        }

        //Arrays.sort(array);

        System.out.print("array:");
        for(int i : array)
            System.out.print(i + " ");
        System.out.println("");
        //System.out.println("result:" + BinarySearch.binarySearchLoop(array, 8));
        //System.out.println("result:" + BinarySearch.binarySearchRecursive(array, 0, array.length-1,8));

        //int[] result = QucikSort.quickSort(array, 0, array.length-1);
        QucikSort.quickSort(array, 0, array.length-1);
        for(int i : array)
            System.out.print(i + " ");

    }
}
