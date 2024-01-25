package algorithm_ex;

public class BinarySearch {

    static int binarySearchLoop(int[] array, int s){

        int end = array.length-1;
        int start = 0;
        int mid = (start+end)/2;

        while(start <= end){
            mid = (start+end)/2;

            if(array[mid] == s) return mid;
            if(start >= end) break;

            if(array[mid] < s){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return -1;
    }

    static int binarySearchRecursive(int[] array, int start, int end, int searchNum){

        int mid = (start+end)/2;
        int v = array[mid];
        if(v == searchNum) return mid;
        if(start >= end) return -1;

        int result;
        if(v > searchNum)
            result = binarySearchRecursive(array,start, mid, searchNum);
        else
            result = binarySearchRecursive(array,mid+1, end, searchNum);

        return result;
    }
}
