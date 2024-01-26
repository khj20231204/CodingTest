package algorithm_ex;

public class QucikSort {

    static void quickSort(int[] arr, int left, int right){
        //left와 right는 값이 정해져서 넘어온다.
        int pL = left;
        int pR = right;
        int pivot = arr[(pL+pR)/2]; //pivot구하기

        while(pL < pR) {

            while (arr[pL] < pivot) pL++;
            while (arr[pR] > pivot) pR--;

            int tmp = arr[pL];
            arr[pL] = arr[pR];
            arr[pR] = tmp;
            pL++;
            pR--;

        }

        if(left < pR) quickSort(arr, left, pR);
        if(pL < right) quickSort(arr, pL, right);
    }
}
