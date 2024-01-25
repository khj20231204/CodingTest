package algorithm_ex;

public class EuclideanRecursive {

    static int euclideanRecursive(int shortSide, int modNumber){

        System.out.println(shortSide + " before");
        if(modNumber == 0) return shortSide;
        System.out.println(shortSide + " after");

        return shortSide > modNumber ? euclideanRecursive(modNumber, shortSide%modNumber) : euclideanRecursive(shortSide, modNumber%shortSide);
    }
}
