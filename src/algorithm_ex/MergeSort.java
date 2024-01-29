package algorithm_ex;
import java.util.*;
public class MergeSort {
    static void mergeSort(int[] array){
        int[] arrayCopy = new int[array.length];

        mergeSortUtility(array, arrayCopy, 0, array.length-1);
    }

    static void mergeSortUtility(int[] array, int[] arrayCopy, int left, int right){
        int mid = (left+right)/2;
        System.out.println("left:"+left+" ,right:"+right);
        if(left < right) { 
            mergeSortUtility(array, arrayCopy, left, mid);
            mergeSortUtility(array, arrayCopy, mid + 1, right);
            sorting(array, arrayCopy, left, mid, right);
        }
    }

    static void sorting(int[] array, int[] arrayCopy, int left, int mid, int right){
        System.out.println("left:"+left+" ,right:"+right);
        
        int idxMerge = left; //임시 저장 배열 index역시 left부터

        //나뉘는 범위 left1~mid / mid+1(left2)~right
        //index로 배열을 나눠서 2개의 배열로 보고 병합을 한다
        int idxLeft1 = left;
        int idxLeft2 = mid+1;

        /*
        메소드끼리 주고 받는 배열은 array이기 때문에 array를 이동 시켜서 결과값을 가져오기 위해 현
        재 array에 있는 값을 arrayCopy에 복사를 해서 arrayCopy에서 비교 후 array에 집어넣는다.
        */
        for(int i=left ; i<=right ; i++) arrayCopy[i] = array[i];

        //arrayCopy = Arrays.copyOf(array, array.length);
        //for(int i : arrayCopy) System.out.print(i + " ");
        //System.out.println(" ");

        while(idxLeft1<=mid && idxLeft2<=right){
            if(arrayCopy[idxLeft1] < arrayCopy[idxLeft2]){
                array[idxMerge++] = arrayCopy[idxLeft1++];
            }else{
                array[idxMerge++] = arrayCopy[idxLeft2++];
            }
        }

        while(idxLeft1<=mid) array[idxMerge++] = arrayCopy[idxLeft1++];
        while(idxLeft2<=right) array[idxMerge++] = arrayCopy[idxLeft2++];
    }
}
