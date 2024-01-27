package algorithm_ex;

public class QuickSort {

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

    static void quickSort2(int[] arr, int left, int right){

        if(left == right) return;

        int pivot = arr[(left+right)/2];

        int pL = left;
        int pR = right;
        //System.out.println("start pivot:"+pivot+" ,pL:"+pL+" ,pR:"+pR);

        while(pL<pR){

            while(pivot > arr[pL]) pL++; //left가 pivot보다 크거나 같으면 멈춤
            while(pivot < arr[pR]) pR--; //right가 pivot보다 작거나 같으면 멈춤
            System.out.println("pL:"+pL+" ,pR:"+pR);
            int tmp = arr[pL];
            arr[pL] = arr[pR];
            arr[pR] = tmp;

            pL++;
            pR--;
        }

        if(left < pR) quickSort2(arr, left, pR);
        if(pL <right) quickSort2(arr, pL, right);
    }

}
